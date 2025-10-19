package com.mvphub.domain.tag.service;

import com.mvphub.domain.activity.adapter.repository.ITagRepository;
import com.mvphub.domain.tag.model.entity.CrowdTagsJobEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mvp
 * @description 人群标签任务实现类
 * @create 2025年10月19日
 */

@Service
@Slf4j
public class TagService implements ITagService {

    @Resource
    private ITagRepository tagRepository;

    @Override
    public void executeTagBatchJob(String tagId, String batchId) {
        log.info("人群标签批次任务 tagId:{} batchId:{}", tagId, batchId);

        // 1. 查询批次任务
        CrowdTagsJobEntity crowdTagsJobEntity = tagRepository.queryCrowdTagsJobEntity(tagId, batchId);

        // 2. 采集用户数据 - 这部分需要采集用户的消费类数据，后续有用户发起拼单后再处理。
        // todo

        // 3. 数据写入记录
        List<String> userIdList = new ArrayList<String>() {{
            add("mvp");
            add("myf");
        }};

        // 4. 一般人群标签的处理在公司中，会有专门的数据数仓团队通过脚本方式写入到数据库，就不用这样一个个或者批次来写。
        userIdList.forEach(userId -> {
            tagRepository.addCrowdTagsUserId(tagId, userId);
        });

        // 5. 更新人群标签统计量
        tagRepository.updateCrowdTagsStatistics(tagId, userIdList.size());

    }
}
