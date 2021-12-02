package com.ecn.iemjava.models;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
    public void sendMail(Employee employee, Intermission intermission) throws MailjetException, MailjetSocketTimeoutException {
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;

        client = new MailjetClient("4da0bd334ede8628156f9be46a280fea", "aeb24cd7ae9ef9723aae133f73106b0a", new ClientOptions("v3.1"));
        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "jeremy.grosjean.icam@gmail.com")
                                        .put("Name", "Jeremy"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", employee.getEmail())
                                                .put("Name", employee.getFirstName())))
                                .put(Emailv31.Message.SUBJECT, "Entrée en intermission")
                                .put(Emailv31.Message.HTMLPART, "<p>Bonjour " + employee.getFirstName() +",</p>" +
                                        "<p>Ta période d’intermission va débuter le " +intermission.getStartDate() +".</p>" +
                                        "<p>Ton Staffing Partner, prendra rendez-vous pour un échange sous peu.\n</p>" +
                                        "<p>Voici les premières informations qui t’aideront à trouver tes repères pendant cette période.Tout d’abord, rejoins le <a href='https://teams.microsoft.com/l/team/19%3Ac87c08ac935d4512835b83fcce39542d%40thread.tacv2/conversations?groupId=0359a3c1-944b-497c-985a-746866e59916&tenantId=76a2ae5a-9f00-4f6b-95ed-5d33d77c4d61'>Teams Intermission</a> qui te présente dans un parcours ludique les différentes étapes à suivre avant et pendant ton intermission.</p>" +
                                        "<p>Il te permet entre autres d’identifier les premières étapes à suivre pour bien préparer ton échange avec ton Staffing Partner: mise à jour de ton <a href='https://456cv.fr.capgemini.com/Summary.aspx'>CV</a>, la récupération des feedback Perform / MyPath et la mise à jour de la WTR / TWEB.</p>")
                                .put(Emailv31.Message.CUSTOMID, "IntermissionFirstStep")));
        response = client.post(request);
        System.out.println(response.getStatus());
        System.out.println(response.getData());
    }
}
