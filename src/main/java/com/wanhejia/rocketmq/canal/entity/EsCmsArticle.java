package com.wanhejia.rocketmq.canal.entity;
import java.io.Serializable;
import java.util.Date;

/**
 * Author:zhansan
 * Date:2021/11/29
 * Description:
 */
public class EsCmsArticle implements Serializable {

    private Long courseId;

    /** 标题 */
    private String title;

    /** 摘要 */
    private String abstractX;

    /** 内容 */
    private String content;

    /** 年龄段 */
    private String ageRange;

    /** 图片 */
    private String image;

    /** 查看次数 */
    private Long viewNumber;

    /** 作者 */
    private String author;

    /** 来源 */
    private String source;

    /** 所属分类 */
    private Long classId;

    /** 关键字 */
    private String keyWords;

    /** 描述 */
    private String description;

    /** 文章url */
    private String url;

    /**
     * 文章状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public void setCourseId(Long courseId)
    {
        this.courseId = courseId;
    }

    public Long getCourseId()
    {
        return courseId;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setAbstractX(String abstractX)
    {
        this.abstractX = abstractX;
    }

    public String getAbstractX()
    {
        return abstractX;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setAgeRange(String ageRange)
    {
        this.ageRange = ageRange;
    }

    public String getAgeRange()
    {
        return ageRange;
    }
    public void setImage(String image)
    {
        this.image = image;
    }

    public String getImage()
    {
        return image;
    }
    public void setViewNumber(Long viewNumber)
    {
        this.viewNumber = viewNumber;
    }

    public Long getViewNumber()
    {
        return viewNumber;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return author;
    }
    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSource()
    {
        return source;
    }
    public void setClassId(Long classId)
    {
        this.classId = classId;
    }

    public Long getClassId()
    {
        return classId;
    }
    public void setKeyWords(String keyWords)
    {
        this.keyWords = keyWords;
    }

    public String getKeyWords()
    {
        return keyWords;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CmsArticle{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", abstractX='" + abstractX + '\'' +
                ", content='" + content + '\'' +
                ", ageRange='" + ageRange + '\'' +
                ", image='" + image + '\'' +
                ", viewNumber=" + viewNumber +
                ", author='" + author + '\'' +
                ", source='" + source + '\'' +
                ", classId=" + classId +
                ", keyWords='" + keyWords + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}