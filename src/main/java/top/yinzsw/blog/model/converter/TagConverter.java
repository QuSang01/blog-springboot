package top.yinzsw.blog.model.converter;

import org.mapstruct.*;
import top.yinzsw.blog.model.dto.TagMapsDTO;
import top.yinzsw.blog.model.po.TagPO;
import top.yinzsw.blog.model.request.TagReq;
import top.yinzsw.blog.model.vo.TagBackgroundSearchVO;
import top.yinzsw.blog.model.vo.TagVO;

import java.util.List;

/**
 * 标签数据模型转换器
 *
 * @author yinzsW
 * @since 23/01/12
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagConverter {
    List<TagVO> toTagVO(List<TagPO> tagPOList);

    List<TagBackgroundSearchVO> toTagSearchVO(List<TagPO> tagPOS, @Context TagMapsDTO tagMapsDTO);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    TagPO toTagPO(TagReq tagReq);


    @SuppressWarnings("unchecked")
    @ObjectFactory
    default <T> T defaultCreator(TagPO origin,
                                 @Context TagMapsDTO tagMapsDTO,
                                 @TargetType Class<T> targetType) {
        Long tagId = origin.getId();
        Long count = tagMapsDTO.getMapArticleCount().get(tagId);

        if (targetType.isAssignableFrom(TagBackgroundSearchVO.class)) {
            return (T) new TagBackgroundSearchVO().setArticleCount(count);
        }

        throw new UnsupportedOperationException();
    }
}
