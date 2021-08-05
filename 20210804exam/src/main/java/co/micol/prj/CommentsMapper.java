package co.micol.prj;

import co.micol.prj.Comments;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENTS
     *
     * @mbg.generated Wed Aug 04 14:24:14 KST 2021
     */
    int deleteByPrimaryKey(@Param("sno") Short sno, @Param("cno") Short cno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENTS
     *
     * @mbg.generated Wed Aug 04 14:24:14 KST 2021
     */
    int insert(Comments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENTS
     *
     * @mbg.generated Wed Aug 04 14:24:14 KST 2021
     */
    Comments selectByPrimaryKey(@Param("sno") Short sno, @Param("cno") Short cno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENTS
     *
     * @mbg.generated Wed Aug 04 14:24:14 KST 2021
     */
    List<Comments> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENTS
     *
     * @mbg.generated Wed Aug 04 14:24:14 KST 2021
     */
    int updateByPrimaryKey(Comments record);
}