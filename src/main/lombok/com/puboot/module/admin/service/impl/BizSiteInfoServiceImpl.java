// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.module.admin.service.impl;

import com.puboot.module.admin.mapper.BizArticleMapper;
import com.puboot.module.admin.service.BizSiteInfoService;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
@Service
public class BizSiteInfoServiceImpl implements BizSiteInfoService {
    private final BizArticleMapper bizArticleMapper;

    @Override
    public Map<String, Object> getSiteInfo() {
        return bizArticleMapper.getSiteInfo();
    }

    @java.lang.SuppressWarnings("all")
    public BizSiteInfoServiceImpl(final BizArticleMapper bizArticleMapper) {
        this.bizArticleMapper = bizArticleMapper;
    }
}
