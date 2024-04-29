package org.example.ta.Service;

import org.example.ta.Model.User;
import org.example.ta.Model.UserData;
import org.example.ta.Repository.IUserDao;
import org.example.ta.Repository.IUserDataDao;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userDataService {

    @Autowired
    IUserDataDao dataDao;

    @Autowired
    IUserDao userDao;

    public String fillForm(UserData data) {
        User oldUser = userDao.findByEmail(data.getEmail());
        System.out.println("-------------------------------");
        System.out.println(data);
        System.out.println("--------------------------------");
        if (oldUser != null && data.getEmail().equalsIgnoreCase(oldUser.getEmail())) {
            if (data.getPreviouslyTa() == null) {
                data.setPreviouslyTa(" ");
            }
            if (data.getTaStartDate() == null) {
                data.setTaStartDate(" ");
            }
            if (data.getTaEndDate() == null) {
                data.setTaEndDate(" ");
            }
            if (data.getStatus1() == null) {
                data.setStatus1(" ");
            }
            if (data.getStatus2() == null) {
                data.setStatus2(" ");
            }
            if (data.getStatus3() == null) {
                data.setStatus3(" ");
            }
            if (data.getAssignTaskDone() == null) {
                data.setAssignTaskDone(" ");
            }
            if (data.getCommentedByInstructor() == null) {
                data.setCommentedByInstructor(" ");
            }
            if (data.getSelectedOrRejected() == null) {
                data.setSelectedOrRejected(" ");
            }
            if (data.getAcceptOrRejectOffer() == null) {
                data.setAcceptOrRejectOffer(" ");
            }
            dataDao.save(data);
            oldUser.setApplied(true);
            return "user data saved !";
        }
        return "user not found !";
    }

    public String assignTask(String assignData) throws JSONException {

        JSONObject newJson = new JSONObject(assignData);
        UserData newData = dataDao.findByEmail(newJson.getString("email"));

        if (newData != null) {
            newData.setAssignTask(newJson.getString("assignTask"));
            dataDao.save(newData);
            return "data updated";
        }
        return "data not found !!";
    }

    public String assignTaskDone(String taskDone) throws JSONException {
        JSONObject task = new JSONObject(taskDone);
        UserData checkData = dataDao.findByEmail(task.getString("email"));

        if (checkData != null) {
            checkData.setAssignTaskDone(task.getString("assignTaskDone"));
            dataDao.save(checkData);
            return "assignTaskDone updated !";
        }
        return "data not found !";
    }

    public String forwardOrRejected(String forwardData) throws JSONException {
        JSONObject forward = new JSONObject(forwardData);
        UserData eligible = dataDao.findByEmail(forward.getString("email"));

        if (eligible != null) {
            if (forward.getBoolean("rejectOrForward")) {
                eligible.setStatus2("department staff");
                dataDao.save(eligible);
            } else {
                eligible.setStatus2("Rejected");
                dataDao.save(eligible);
            }
            return "forwardOrRejected Updated !";
        }
        return "Not Found !";
    }

    public String commented(String comment) throws JSONException {
        JSONObject commentOnTop = new JSONObject(comment);
        UserData isCommented = dataDao.findByEmail(commentOnTop.getString("email"));

        if (isCommented != null) {
            isCommented.setCommentedByInstructor(commentOnTop.getString("commentedByInstructor"));
            dataDao.save(isCommented);
            return "comment Added !";
        }
        return "Not Found !";
    }

    public String selectReject(String selection) throws JSONException {
        JSONObject selects = new JSONObject(selection);
        UserData isSelected = dataDao.findByEmail(selects.getString("email"));

        if (isSelected != null) {
            if (selects.getBoolean("selectedOrRejected")) {
                isSelected.setStatus1("selected");
            } else {
                isSelected.setStatus1("Rejected");
            }
            dataDao.save(isSelected);
            return "Selection Changes Added !";
        }
        return "Not Found !";
    }

    public String acceptReject(String offer) throws JSONException {
        JSONObject offers = new JSONObject(offer);
        UserData offered = dataDao.findByEmail(offers.getString("email"));

        if (offered != null) {
            if (offers.getBoolean("acceptOrRejectOffer")) {
                offered.setStatus3("Accepted");
            } else {
                offered.setStatus3("Declined");
            }
            dataDao.save(offered);
            return "Offer Changes Added !";
        }
        return "Not Found !";
    }

    public List<UserData> getAllApplicants() {
        return dataDao.findAll();
    }
}
