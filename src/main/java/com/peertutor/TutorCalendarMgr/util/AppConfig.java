package com.peertutor.TutorCalendarMgr.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix="app-config")
public class AppConfig {

    private Map<String, String> bookmarkMgr;
    private Map<String, String> studentMgr;
    private Map<String, String> tutorMgr;
    private Map<String, String> notificationMgr;
    private Map<String, String> reviewMgr;
    private Map<String, String> recommendationMgr;
    private Map<String, String> tuitionOrderMgr;
    private Map<String, String> accountMgr;
    private Map<String, String> tutorCalendarMgr;

    public Map<String, String> getBookmarkMgr() {
        return bookmarkMgr;
    }

    public void setBookmarkMgr(Map<String, String> bookmarkMgr) {
        this.bookmarkMgr = bookmarkMgr;
    }

    public Map<String, String> getStudentMgr() {
        return studentMgr;
    }

    public void setStudentMgr(Map<String, String> studentMgr) {
        this.studentMgr = studentMgr;
    }

    public Map<String, String> getTutorMgr() {
        return tutorMgr;
    }

    public void setTutorMgr(Map<String, String> tutorMgr) {
        this.tutorMgr = tutorMgr;
    }

    public Map<String, String> getNotificationMgr() {
        return notificationMgr;
    }

    public void setNotificationMgr(Map<String, String> notificationMgr) {
        this.notificationMgr = notificationMgr;
    }

    public Map<String, String> getReviewMgr() {
        return reviewMgr;
    }

    public void setReviewMgr(Map<String, String> reviewMgr) {
        this.reviewMgr = reviewMgr;
    }

    public Map<String, String> getRecommendationMgr() {
        return recommendationMgr;
    }

    public void setRecommendationMgr(Map<String, String> recommendationMgr) {
        this.recommendationMgr = recommendationMgr;
    }

    public Map<String, String> getTuitionOrderMgr() {
        return tuitionOrderMgr;
    }

    public void setTuitionOrderMgr(Map<String, String> tuitionOrderMgr) {
        this.tuitionOrderMgr = tuitionOrderMgr;
    }

    public Map<String, String> getAccountMgr() {
        return accountMgr;
    }

    public void setAccountMgr(Map<String, String> accountMgr) {
        this.accountMgr = accountMgr;
    }

    public Map<String, String> getTutorCalendarMgr() {
        return tutorCalendarMgr;
    }

    public void setTutorCalendarMgr(Map<String, String> tutorCalendarMgr) {
        this.tutorCalendarMgr = tutorCalendarMgr;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "bookmarkMgr=" + bookmarkMgr +
                ", studentMgr=" + studentMgr +
                ", tutorMgr=" + tutorMgr +
                ", notificationMgr=" + notificationMgr +
                ", reviewMgr=" + reviewMgr +
                ", recommendationMgr=" + recommendationMgr +
                ", tuitionOrderMgr=" + tuitionOrderMgr +
                ", accountMgr=" + accountMgr +
                ", tutorCalendarMgr=" + tutorCalendarMgr +
                '}';
    }

}
