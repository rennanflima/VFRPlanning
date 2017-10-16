/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rennan.goldplanning.util.mail;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.outjected.email.api.MailMessage;
import com.outjected.email.api.SessionConfig;
import com.outjected.email.impl.MailMessageImpl;

/**
 *
 * @author rennan.lima
 */
@RequestScoped
public class Mailer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SessionConfig config;

    public MailMessage novaMensagem() {
        return new MailMessageImpl(this.config);
    }

}
