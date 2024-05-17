package com.ssafy.yeohaengdam.notice.service;

import com.ssafy.yeohaengdam.notice.entity.Notice;
import com.ssafy.yeohaengdam.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssafy.yeohaengdam.notice.dto.NoticeData.*;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{

    private final NoticeMapper noticeMapper;

    @Override
    public List<Detail> findAll() {
        return noticeMapper.findAll();
    }

    @Override
    public void create(int userId, Create create) {
        Notice newNotice = Notice.builder()
                .userId(userId)
                .title(create.getTitle())
                .content(create.getContent())
                .build();
        noticeMapper.create(newNotice);
    }


    @Override
    public void delete(int noticeId, int userId) {
        noticeMapper.delete(noticeId);
    }

    @Override
    public Detail findById(int noticeId) {
        return noticeMapper.findById(noticeId);
    }

    @Override
    public void update(int noticeId, Create update, int userId) {
        Notice updatedNotice = Notice.builder()
                .noticeId(noticeId)
                .title(update.getTitle())
                .content(update.getContent())
                .build();
        noticeMapper.update(updatedNotice);
    }
}
