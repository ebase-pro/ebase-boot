package me.dwliu.framework.core.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import me.dwliu.framework.common.enums.YesOrNoEnum;
import me.dwliu.framework.core.security.entity.UserInfoDetails;
import me.dwliu.framework.core.security.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;


/**
 * 公共字段，自动填充值
 *
 * @author liudw
 * @date 2019-07-02 22:20
 **/
//@Component
public class FieldMetaObjectHandler implements MetaObjectHandler {
    private final static String CREATE_TIME = "createTime";
    private final static String UPDATE_TIME = "updateTime";

    private final static String CREATE_BY = "createBy";
    private final static String UPDATE_BY = "updateBy";
    private final static String CREATE_DEPT = "createDept";
    private final static String DEL_FLAG = "delFlag";

    @Override
    public void insertFill(MetaObject metaObject) {
        UserInfoDetails user = SecurityUtils.getUser();
        if (user != null) {
            //创建者
            if (metaObject.hasSetter(CREATE_BY)) {
                strictInsertFill(metaObject, CREATE_BY, String.class, user.getUserId());
            }
            //创建者所属部门
            if (metaObject.hasSetter(CREATE_DEPT)) {
                this.strictInsertFill(metaObject, CREATE_DEPT, String.class, user.getDeptId());
            }
            //更新者
            if (metaObject.hasSetter(UPDATE_BY)) {
                strictInsertFill(metaObject, UPDATE_BY, String.class, user.getUserId());
            }
        }

        Date date = new Date(System.currentTimeMillis());
        //创建时间
        if (metaObject.hasSetter(CREATE_TIME)) {
            strictInsertFill(metaObject, CREATE_TIME, Date.class, date);
        }
        //更新时间
        if (metaObject.hasSetter(UPDATE_TIME)) {
            strictInsertFill(metaObject, UPDATE_TIME, Date.class, date);
        }
        //是否删除 默认为0 不删除
        if (metaObject.hasSetter(DEL_FLAG)) {
            strictInsertFill(metaObject, DEL_FLAG, Integer.class, YesOrNoEnum.NO.getValue());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        UserInfoDetails user = SecurityUtils.getUser();
        if (user != null) {
            //更新者
            if (metaObject.hasSetter(UPDATE_BY)) {
                if (null != getFieldValByName(UPDATE_BY, metaObject)) {
                    //bugfix 由于更新字段有值，更新时间不生效
                    setFieldValByName(UPDATE_BY, user.getUserId(), metaObject);
                } else {
                    this.strictInsertFill(metaObject, UPDATE_BY, String.class, user.getUserId());
                }
            }

        }


        //更新时间
        if (metaObject.hasSetter(UPDATE_TIME)) {
            if (null != getFieldValByName(UPDATE_TIME, metaObject)) {
                //bugfix 由于更新字段有值，更新时间不生效
                setFieldValByName(UPDATE_TIME, new Date(), metaObject);
            } else {
                this.strictUpdateFill(metaObject, UPDATE_TIME, Date.class, new Date());
            }
        }

    }
}
