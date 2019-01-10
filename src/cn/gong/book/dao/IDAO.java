package cn.gong.book.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/*这个接口表示一个公共的DAO接口
<K>表示主键
<V>表示要操作的对象
 */
public interface IDAO<K,V> {
    /*实现数据增加操作
    vo表示要执行操作的对象
    成功返回true，失败返回false
     */
    public boolean doCreate(V vo)throws SQLException;

    /*实现数据操作
    vo表示要执行更新对象
    成功返回true，失败返回false
     */
    public boolean doUpdate(V vo)throws SQLException;

    /*
    实现数据批量删除
    ids表示要执行删除的数据集合
    成功返回true，失败返回false
     */
    public boolean doRemove(Set<?> ids)throws SQLException;

    /*
    根据用户提供的id进行查询
    id表使用执行查询的行
    查询成功返回该数据行中的记录，失败返回null
     */
    public V findByID(K id)throws SQLException;

    /*
    实现数据全部查询
    成功返回全部数据，失败返回null
     */
    public List<V> findAll()throws SQLException;

    /*
    实现数据分页操作
    column表示要执行查询列
    keyword表示查询关键字
    currentPage表示当前页
    linesize表示每页显示记录数
    成功返回满足条件的数据，失败返回null
     */
    public List<V> findAllBySplit(String column,String keyWord,Integer currentPage,Integer lineSize)throws SQLException;

    /*
    实现数据量统计操作
    column表示要执行统计列
    keyword表示统计查询关键字
    成功返回数据量，失败返回0
     */
    public Integer getAllCount(String column,String keyWord)throws SQLException;



}






















