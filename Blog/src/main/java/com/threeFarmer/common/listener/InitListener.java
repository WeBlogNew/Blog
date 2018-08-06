package com.threeFarmer.common.listener;

import com.threeFarmer.common.Const;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 初始化服务器
 */
public class InitListener implements ServletContextListener {

    public InitListener() {
    }


    public void contextInitialized(ServletContextEvent sce) {
        try {
            Const.PROJECT_PATH = sce.getServletContext().getContextPath();
            //System.out.println("Tomcat has been initialized by my own basePath : " + Const.PROJECT_PATH);
            sce.getServletContext().setAttribute("basePath", Const.PROJECT_PATH);

            String managePath = Const.PROJECT_PATH + Const.MANAGE_PATH;
            sce.getServletContext().setAttribute("managePath",managePath);

/*            WeBlogConfig jeesnsConfig = SpringContextHolder.getBean("jeesnsConfig");
            sce.getServletContext().setAttribute("jeesnsConfig",jeesnsConfig);
            String frontTemplate = jeesnsConfig.getFrontTemplate();
            sce.getServletContext().setAttribute("frontTemplate",frontTemplate);
            String managePath = Const.PROJECT_PATH + "/" + jeesnsConfig.getManagePath();
            sce.getServletContext().setAttribute("managePath",managePath);
            IConfigService configService = SpringContextHolder.getBean("configService");
            List<Config> configList = configService.allList();
            for (Config config : configList) {
                sce.getServletContext().setAttribute(config.getJkey().toUpperCase(),config.getJvalue());
            }*/
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
