package demik.springcloud.studentmanagementsystem9001.manager;

import demik.springcloud.entity.domain.dto.AClassInfoDTO;
import demik.springcloud.entity.domain.vo.AClassInfoVO;
import demik.springcloud.studentmanagementsystem9001.mapper.AClassInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/14 2:37 PM
 * @since JDK 1.8
 */
@Repository
public class AClassInfoManager {

    @Autowired
    private AClassInfoMapper aClassInfoMapper;

    /**
     * 添加一个班级
     * @param aClassInfoVO
     * @return
     */
    public boolean addAClass(AClassInfoVO aClassInfoVO) {
        return aClassInfoMapper.addAClass(aClassInfoVO);
    }
    /**
     * 删除一个班级
     * @param id
     * @return
     */
    public boolean deleteAClass(Integer id) {
        return aClassInfoMapper.deleteAClass(id);
    }
    /**
     * 更新一个班级
     * @param aClassInfoVO
     * @return
     */
    public boolean updateAClass(AClassInfoVO aClassInfoVO) {
        return aClassInfoMapper.updateAClass(aClassInfoVO);
    }

    /**
     * 查询所有班级的原始信息
     * @return
     */
    public List<AClassInfoVO> findAllAClass() {
        return aClassInfoMapper.findAllAClass();
    }
    /**
     * 查询单个班级的原始信息
     * @return
     */
    public AClassInfoVO findAClassById(Integer id) {
        return aClassInfoMapper.findAClassById(id);
    }
    /**
     * 根据专业id查询班级
     * @return
     */
    public List<AClassInfoVO> findAClassInfoByPId(Integer pId){
        return aClassInfoMapper.findAClassInfoByPId(pId);
    }
    /**
     * 根据年级id查询班级
     * @param gId
     * @return
     */
    public List<AClassInfoVO> findAClassInfoByGId(Integer gId) {
        return aClassInfoMapper.findAClassInfoByGId(gId);
    }

    public AClassInfoVO findAClassByClassName(String aClassName) {
        return aClassInfoMapper.findAClassByClassName(aClassName);
    }
}
