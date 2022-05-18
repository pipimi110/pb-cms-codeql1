package com.puboot.module.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.puboot.module.admin.model.BizArticleLook;
import com.puboot.module.admin.service.BizArticleLookService;
import com.puboot.module.admin.service.BizArticleService;
import com.puboot.module.admin.service.BizCommentService;
import com.puboot.module.admin.service.BizStatisticService;
import com.puboot.module.admin.vo.StatisticVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Nobita
 * @date 2021/1/12 3:35 下午
 */
@Service
@AllArgsConstructor
public class BizStatisticServiceImpl implements BizStatisticService {

    private final BizArticleService articleService;
    private final BizCommentService commentService;
    private final BizArticleLookService articleLookService;

    @Override
    public StatisticVo indexStatistic() {
        int articleCount = articleService.count();
        int commentCount = commentService.count();
        int lookCount = articleLookService.count();
        int userCount = articleLookService.count(Wrappers.<BizArticleLook>query().select("DISTINCT user_ip"));
        int recentDays = 6;
        Map<String, Integer> lookCountByDay = articleLookService.lookCountByDay(recentDays);
        Map<String, Integer> userCountByDay = articleLookService.userCountByDay(recentDays);
        return StatisticVo.builder().articleCount(articleCount).commentCount(commentCount).lookCount(lookCount).userCount(userCount).lookCountByDay(lookCountByDay).userCountByDay(userCountByDay).build();
    }
}
