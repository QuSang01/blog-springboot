package top.yinzsw.blog.manager;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.scheduling.annotation.Async;
import top.yinzsw.blog.model.po.RoleMtmResourcePO;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * 角色,资源关联表 通用处理层
 *
 * @author yinzsW
 * @since 23/01/02
 */

public interface RoleMtmResourceManager extends IService<RoleMtmResourcePO> {

    /**
     * 根据资源id获取角色id列表
     *
     * @param resourceId 资源id
     * @return 角色id列表
     */
    List<Long> listRoleIdsByResourceId(Long resourceId);

    /**
     * 根据角色id列表获取 关联表
     *
     * @param roleIds 角色id列表
     * @return 关联表
     */
    @Async
    CompletableFuture<Map<Long, List<Long>>> asyncGetMappingByRoleIds(List<Long> roleIds);
}