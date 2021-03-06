package demik.springcloud.teachermanagementsystem8001.controller;

import demik.springcloud.entity.commonbox.Result;
import demik.springcloud.entity.commonbox.ResultCode;
import demik.springcloud.entity.commonbox.ResultGenerator;
import demik.springcloud.entity.domain.dto.ProjectNameDTO;
import demik.springcloud.entity.domain.dto.TeacherNameDTO;
import demik.springcloud.entity.domain.po.ProjectInfoPO;
import demik.springcloud.entity.domain.po.TeacherProjectPO;
import demik.springcloud.entity.domain.po.WorkInfoPO;
import demik.springcloud.entity.domain.vo.ProjectIdVO;
import demik.springcloud.entity.domain.vo.TeacherProjectVO;
import demik.springcloud.teachermanagementsystem8001.service.ProjectInfoService;
import demik.springcloud.teachermanagementsystem8001.service.TeacherInfoService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 3:40 PM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/project-info")
@ApiModel(description = "项目管理模块")
public class ProjectInfoController {

    @Autowired
    private ProjectInfoService projectInfoService;
    @Autowired
    private TeacherInfoService teacherInfoService;
    /**
     * 查询所有的项目信息
     * @return
     */
    @ApiOperation(value = "查询所有的项目信息", httpMethod = "POST")
    @PostMapping("/findAllProjectinfo")
    public Result findAllProjectinfo(){
        List<ProjectInfoPO> vos = projectInfoService.findAllProjectinfo();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 查询所有的教师项目信息
     * @return
     */
    @ApiOperation(value = "查询所有的教师项目信息", httpMethod = "POST")
    @PostMapping("/findAllTeacherProjectinfo")
    public Result findAllProjectTeacherinfo(){
        List<TeacherProjectPO> vos = projectInfoService.findAllProjectTeacherinfo();
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据教师名称查询教师项目信息
     * @return
     */
    @ApiOperation(value = "根据教师名称查询教师项目信息", httpMethod = "POST")
    @PostMapping("/findTeacherProjectinfoByTeacherName")
    public Result findTeacherProjectinfoByTeacherName(@RequestBody TeacherNameDTO teacherNameDTO){
        List<TeacherProjectPO> vos = projectInfoService.findTeacherProjectinfoByTeacherName(teacherNameDTO.getTeacherName());
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据项目名称查询教师项目信息
     * @return
     */
    @ApiOperation(value = "根据项目名称查询教师项目信息", httpMethod = "POST")
    @PostMapping("/findTeacherProjectinfoByProjectName")
    public Result findTeacherProjectinfoByProjectName(@RequestBody ProjectNameDTO projectNameDTO){
        List<TeacherProjectPO> vos = projectInfoService.findTeacherProjectinfoByProjectName(projectNameDTO.getProjectName());
        if(vos!=null&&vos.size()>0){
            return ResultGenerator.genSuccessResult(vos);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }
    /**
     * 根据id查询项目
     * @return
     */
    @ApiOperation(value = "根据id查询项目", httpMethod = "POST")
    @PostMapping("/findProjectInfoById")
    public Result findProjectInfoById(@RequestBody ProjectIdVO projectIdVO){
        ProjectInfoPO po = projectInfoService.findProjectInfoById(projectIdVO.getId());
        if(po!=null){
            return ResultGenerator.genSuccessResult(po);
        }
        return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
    }

    /**
     * 添加一条教师项目信息
     * @param teacherProjectVO
     * @return
     */
    @ApiOperation(value = "添加一条教师项目信息", httpMethod = "POST")
    @PostMapping("/addProjectInfo")
    public Result addTeacherProjectInfo(@RequestBody TeacherProjectVO teacherProjectVO){
        if(teacherInfoService.findTeacherInfoById(teacherProjectVO.getTeacherId())==null){
            return ResultGenerator.genSuccessResult("没有该教师");
        }
        if(teacherProjectVO.getType()==null){
            return ResultGenerator.genSuccessResult("type不能为空");
        }else if(teacherProjectVO.getType()==1){
            ProjectInfoPO projectInfoPO = projectInfoService.findProjectInfoById(teacherProjectVO.getProjectId());
            if(projectInfoPO==null){
                return ResultGenerator.genSuccessResult("没有该项目");
            }
        }else if(teacherProjectVO.getType()==2){
            if(teacherProjectVO.getProjectName()==null||teacherProjectVO.getProjectName().trim().equals("")){
                return ResultGenerator.genSuccessResult("项目名字不能为空");
            }
            Integer i = projectInfoService.findProjectByName(teacherProjectVO.getProjectName());
            if(i==null){
                ProjectInfoPO po = new ProjectInfoPO();
                po.setProjectName(teacherProjectVO.getProjectName());
                po.setProjectValue(teacherProjectVO.getProjectValue());
                if(!projectInfoService.addProjectInfo(po)){
                    return ResultGenerator.genFailResult("添加一条项目信息失败");
                }
                if(po.getProjectId()==null){
                    return ResultGenerator.genFailResult("返回项目的id失败");
                }
                teacherProjectVO.setProjectId(po.getProjectId());
            }else {
                ResultGenerator.genFailResult("想要添加的项目已经存在");
            }
        }else {
            return ResultGenerator.genSuccessResult("Type传入数据错误");
        }
        if(projectInfoService.addTeacherProjectInfo(teacherProjectVO)){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加一条教师项目信息失败");
    }
}
