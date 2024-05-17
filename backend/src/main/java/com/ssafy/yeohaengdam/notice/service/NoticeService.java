package com.ssafy.yeohaengdam.notice.service;

import java.util.List;

import static com.ssafy.yeohaengdam.notice.dto.NoticeData.*;


public interface NoticeService {

    public List<Detail> findAll();

    public void create(int userId, Create create);


    public void delete(int noticeId);

    public Detail findById(int noticeId);

    public void update(int noticeId, Create update, int userId);
}
