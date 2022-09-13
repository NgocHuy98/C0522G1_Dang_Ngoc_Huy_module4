package com.codegym.repository.impl;

import com.codegym.model.Mailbox;
import com.codegym.repository.IMailboxRepository;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class MailboxRepository implements IMailboxRepository {

    private static List<String> languageList = new ArrayList<>();
    private static List<Integer> pageSizeList = new ArrayList<>();
    private static List<Mailbox> mailboxList = new ArrayList<>();

    static {
        languageList.add("Japanese");
        languageList.add("Chinese");
        languageList.add("English");
        languageList.add("Vietnamese");

        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(20);
        pageSizeList.add(25);

        mailboxList.add(new Mailbox(1, "Japanese", 5, true, "gao ranger"));
        mailboxList.add(new Mailbox(2, "Chinese", 10, false, "xiaochengmeng"));
        mailboxList.add(new Mailbox(3, "English", 15, true, "harry kane"));
        mailboxList.add(new Mailbox(4, "Vietnamese", 20, true, "huy jr"));
        mailboxList.add(new Mailbox(5, "Portuguese", 25, true, "CR7"));
    }

    @Override
    public List<String> findAllLanguage() {
        return languageList;
    }

    @Override
    public List<Integer> findAllPageSize() {
        return pageSizeList;
    }

    @Override
    public List<Mailbox> findAllMail() {
        return mailboxList;
    }

    @Override
    public void save(Mailbox mailbox) {
        mailboxList.add(mailbox);
    }

    @Override
    public Mailbox findById(int id) {
        for (Mailbox mailbox1 : mailboxList) {
            if (mailbox1.getId() == id) {
                return mailbox1;
            }
        }
        return null;
    }

    @Override
    public void update(Mailbox mailbox) {
        for (Mailbox mailbox2 : mailboxList) {
            if (mailbox2.getId() == mailbox.getId()) {
                mailboxList.remove(mailbox2);
                mailboxList.add(mailbox);
                break;
            }
        }

    }
}
