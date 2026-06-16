package com.itheima.pojo;

import com.itheima.anno.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Data
public class Article {
    private Integer id;//主键ID
    @NotEmpty(groups =  {Add.class, Update.class})
    @Pattern(regexp = "^\\S{1,10}$")
    private String title;//文章标题

    @NotEmpty(groups =  {Add.class, Update.class})
    private String content;//文章内容

    @NotEmpty(groups =  {Add.class, Update.class})
    @URL
    private String coverImg;//文章封面

    @NotEmpty(groups =  {Add.class, Update.class})
    @State
    private String state;//发布状态 已发布|草稿9

    @NotNull(groups =  {Add.class, Update.class})
    private Integer categoryId;//文章分类ID
    private Integer createUser;//创建人ID
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间

    public interface Add{
    }
    public interface Update{
    }
}