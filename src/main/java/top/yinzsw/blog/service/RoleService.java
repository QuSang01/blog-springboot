package top.yinzsw.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yinzsw.blog.model.po.RolePO;
import top.yinzsw.blog.model.request.PageReq;
import top.yinzsw.blog.model.request.RoleReq;
import top.yinzsw.blog.model.vo.PageVO;
import top.yinzsw.blog.model.vo.RoleDigestVO;
import top.yinzsw.blog.model.vo.RoleSearchVO;

import java.util.List;

/**
 * @author yinzsW
 * @description 针对表【role(角色表)】的数据库操作Service
 * @createDate 2022-12-15 14:47:44
 */
public interface RoleService extends IService<RolePO> {

    /**
     * 根据用户id获取用户的角色列表
     *
     * @param userId 用户id
     * @return 角色列表
     */
    List<String> getRoleNamesByUserId(Long userId);

    /**
     * 根据资源id获取角色列表
     *
     * @param resourceId 资源id
     * @return 角色列表
     */
    List<String> getRoleNamesByResourceId(Long resourceId);

    /**
     * 获取角色列表
     *
     * @return 角色列表
     */
    List<RoleDigestVO> listDigestRoles();

    /**
     * 根据用户名关键词 分页获取所有用户角色信息
     *
     * @param pageReq  分页信息
     * @param keywords 用户名关键词
     * @return 用户角色列表信息
     */
    PageVO<RoleSearchVO> pageSearchRoles(PageReq pageReq, String keywords);

    /**
     * 更新角色禁用状态
     *
     * @param roleId     角色id
     * @param isDisabled 禁用状态
     * @return 是否成功
     */
    boolean updateRoleIsDisabled(Long roleId, Boolean isDisabled);

    /**
     * 保存或更新角色
     *
     * @param roleReq 角色信息
     * @return 是否成功
     */
    boolean saveOrUpdateRole(RoleReq roleReq);

    /**
     * 批量删除角色
     *
     * @param roleIds 角色id列表
     * @return 是否成功
     */
    boolean deleteRoles(List<Long> roleIds);
}
