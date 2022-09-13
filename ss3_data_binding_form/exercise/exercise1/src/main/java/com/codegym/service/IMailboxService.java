package com.codegym.service;

import com.codegym.model.Mailbox;

import java.util.List;

public interface IMailboxService {

    List<String> findAllLanguage();

    List<Integer> findAllPageSize();

    List<Mailbox> findAllMail();

    void save(Mailbox mailbox);


    Mailbox findById(int id);

    void update(Mailbox mailbox);
}
