package top.yinzsw.blog.model.po;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 文章与标签映射表(多对多)
 *
 * @TableName article_mtm_tag
 */
@TableName(value = "article_mtm_tag")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ArticleMtmTagPO implements Serializable {

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 标签id
     */
    private Long tagId;

    /**
     * 文章数量 GroupBy tagId
     */
    @TableField(value = "COUNT(article_id)", select = false, insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Long articleCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}