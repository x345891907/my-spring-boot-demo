package com.xzh.springbootshiroredissession.service.impl;

import com.xzh.springbootshiroredissession.dao.SysRoleMenuDao;
import com.xzh.springbootshiroredissession.entity.SysRoleMenu;
import com.xzh.springbootshiroredissession.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色与权限关系表(SysRoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-04-14 14:45:52
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRoleMenu queryById(Long id) {
        return this.sysRoleMenuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysRoleMenu> queryAllByLimit(int offset, int limit) {
        return this.sysRoleMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoleMenu insert(SysRoleMenu sysRoleMenu) {
        this.sysRoleMenuDao.insert(sysRoleMenu);
        return sysRoleMenu;
    }

    /**
     * 修改数据
     *
     * @param sysRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoleMenu update(SysRoleMenu sysRoleMenu) {
        this.sysRoleMenuDao.update(sysRoleMenu);
        return this.queryById(sysRoleMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysRoleMenuDao.deleteById(id) > 0;
    }

    @Override
    public int save(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuDao.save(sysRoleMenu);
    }
}