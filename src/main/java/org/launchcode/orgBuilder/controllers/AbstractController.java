package org.launchcode.orgBuilder.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.launchcode.orgBuilder.models.User;
import org.launchcode.orgBuilder.models.dao.AddressDao;
import org.launchcode.orgBuilder.models.dao.AnswerDao;
import org.launchcode.orgBuilder.models.dao.PersonDao;
import org.launchcode.orgBuilder.models.dao.QuestionDao;
import org.launchcode.orgBuilder.models.dao.ResponseDao;
import org.launchcode.orgBuilder.models.dao.TagDao;
import org.launchcode.orgBuilder.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController {

	@Autowired
    protected UserDao userDao;
	
	@Autowired
	protected AnswerDao answerDao;
	
	@Autowired
	protected PersonDao personDao;
	
	@Autowired
	protected QuestionDao questionDao;
	
	@Autowired
	protected ResponseDao responseDao;
	
	@Autowired
	protected AddressDao addressDao;
	
	@Autowired
	protected TagDao tagDao;
	

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {
    	
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findByUid(userId);
    }
    
    protected void setUserInSession(HttpSession session, User user) {
    	session.setAttribute(userSessionKey, user.getUid());
    }
	
	public static boolean exists(String value) {
		/*
		 *  Static method to ensure Strings are not made of spaces
		 *  or empty
		 */
		
		if (value.equals("") || value == null) {
			return false;
		}
		
		Pattern validString = Pattern.compile("^ *$");
		Matcher matcher = validString.matcher(value);
		
		return matcher.matches();
	}
}
