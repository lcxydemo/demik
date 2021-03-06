package demik.springcloud.teachermanagementsystem8001.manager;

import demik.springcloud.entity.domain.dto.VisitSchoolDTO;
import demik.springcloud.entity.domain.po.SchoolPO;
import demik.springcloud.entity.domain.po.VisitSchoolPO;
import demik.springcloud.teachermanagementsystem8001.mapper.VisitSchoolInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/20 3:45 PM
 * @since JDK 1.8
 */
@Repository
public class VisitSchoolInfoManager {
    @Autowired
    private VisitSchoolInfoMapper visitSchoolInfoMapper;

    /**
     * 查询所有的学校信息
     * @return
     */
    public List<SchoolPO> findAllSchoolInfo() {
        return visitSchoolInfoMapper.findAllSchoolInfo();
    }

    /**
     * 查询所有的访学信息
     * @return
     */
    public List<VisitSchoolPO> findAllVisitSchoolInfo() {
        return visitSchoolInfoMapper.findAllVisitSchoolInfo();
    }

    /**
     * 根据id查询学校
     * @param schoolId
     * @return
     */
    public SchoolPO findAllSchoolInfoById(Integer schoolId) {
        return visitSchoolInfoMapper.findAllSchoolInfoById(schoolId);
    }

    /**
     * 添加一条教师访学信息
     * @param visitSchoolDTO
     * @return
     */
    public boolean addVisitSchoolInfo(VisitSchoolDTO visitSchoolDTO) {
        return visitSchoolInfoMapper.addVisitSchoolInfo(visitSchoolDTO);
    }

    /**
     * 添加学校信息
     * @param po
     * @return
     */
    public boolean addSchoolInfo(SchoolPO po) {
        return visitSchoolInfoMapper.addSchoolInfo(po);
    }

    /**
     * 根据id查询访学信息
     * @param id
     * @return
     */
    public VisitSchoolPO findVisitSchoolInfoById(Integer id) {
        return visitSchoolInfoMapper.findVisitSchoolInfoById(id);
    }

    /**
     * 根据id删除访学信息
     * @param id
     * @return
     */
    public boolean deleteVisitSchoolInfoById(Integer id) {
        return visitSchoolInfoMapper.deleteVisitSchoolInfoById(id);
    }

    /**
     * 根据教师姓名查询访学信息
     * @param teacherName
     * @return
     */
    public List<VisitSchoolPO> findVisitSchoolInfoByTeacherName(String teacherName) {
        return visitSchoolInfoMapper.findVisitSchoolInfoByTeacherName(teacherName);
    }

    public List<VisitSchoolPO> findVisitSchoolInfoBySchoolName(String schoolName) {
        return visitSchoolInfoMapper.findVisitSchoolInfoBySchoolName(schoolName);
    }

    public SchoolPO findSchoolInfoByName(String name) {
        return visitSchoolInfoMapper.findSchoolInfoByName(name);
    }
}
