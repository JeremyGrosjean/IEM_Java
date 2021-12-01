package com.ecn.iemjava.models;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

    private JavaMailSender emailSender;


    public SendEmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendMessage(String toEmail, String subject, String text, String fromEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public String createMailMessage(Employee employee, Intermission intermission){
        String text = "Bonjour " + employee.getFirstName() +", \n Ta période d’intermission va débuter le " + intermission.getStartDate() + ".\n" +
                "Ton Staffing Partner prendra rendez-vous pour un échange sous peu.\n" +
                "Voici les premières informations qui t’aideront à trouver tes repères pendant cette période. Tout d’abord, rejoins le Teams Intermission "+
                "qui te présente dans un parcours ludique les différentes étapes à suivre avant et pendant ton intermission." +
                "Il te permet entre autres d’identifier les premières étapes à suivre pour bien préparer ton échange avec ton Staffing Partner : mise à jour "+
                "de ton CV, la récupération des feedback Perform / MyPath et la mise à jour de la WTR / TWEB.\n" +
                "Connecte-toi également aux animations proposées pour lesquelles tu trouveras les agendas dans le Teams Intermission, pour poser tes questions "+
                "et rencontrer les autres collaborateurs en intermission.\n"+
                "Pour tout changement de ton statut durant l'intermission, participation à une AVV, à un projet Ruche, tu dois informer ton Staffing Partner qui "+
                "validera selon les opportunités d'activité.\n \n" +
                "Lien Teams: https://teams.microsoft.com/l/team/19%3Ac87c08ac935d4512835b83fcce39542d%40thread.tacv2/conversations?groupId=0359a3c1-944b-497c-985a-746866e59916&tenantId=76a2ae5a-9f00-4f6b-95ed-5d33d77c4d61 \n"+
                "Lien Cv: https://456cv.fr.capgemini.com/Summary.aspx";
        return text;
    }
}