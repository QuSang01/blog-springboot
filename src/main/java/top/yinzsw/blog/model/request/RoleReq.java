package top.yinzsw.blog.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 用户角色模型
 *
 * @author yinzsW
 * @since 23/01/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "角色模型")
public class RoleReq {

    /**
     * 角色id
     */
    @Min(value = 1, message = "不合法的角色id: ${validatedValue}")
    @Schema(title = "角色id")
    private Long roleId;

    /**
     * 角色名(zh)
     */
    @NotBlank(message = "角色名(zh)不能为空")
    @Schema(title = "角色名(zh)")
    private String roleName;

    /**
     * 角色名(en)
     */
    @NotBlank(message = "角色名(en)不能为空")
    @Schema(title = "角色名(en)")
    private String roleLabel;

    /**
     * 资源列表
     */
    @Schema(title = "资源列表")
    private List<Long> resourceIdList;

    /**
     * 菜单列表
     */
    @Schema(title = "菜单列表")
    private List<Long> menuIdList;
}