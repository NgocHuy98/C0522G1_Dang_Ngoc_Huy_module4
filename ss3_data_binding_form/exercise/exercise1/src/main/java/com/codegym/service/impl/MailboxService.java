package com.codegym.service.impl;

import com.codegym.model.Mailbox;
import com.codegym.repository.IMailboxRepository;
import com.codegym.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailboxService implements IMailboxService {
    @Autowired
    private IMailboxRepository iMailboxRepository;


    @Override
    public List<String> findAllLanguage() {
        return iMailboxRepository.findAllLanguage();
    }

    @Override
    public List<Integer> findAllPageSize() {
        return iMailboxRepository.findAllPageSize();
    }

    @Override
    public List<Mailbox> findAllMail() {
        return iMailboxRepository.findAllMail();
    }

    @Override
    public void save(Mailbox mailbox) {
        iMailboxRepository.save(mailbox);
    }

    @Override
    public Mailbox findById(int id) {
        return iMailboxRepository.findById(id);
    }

    @Override
    public void update(Mailbox mailbox) {
        iMailboxRepository.update(mailbox);
    }
}
