package top.huangqsh.business.tellyou.entity;

import top.huangqsh.core.base.BaseEntity;

import javax.persistence.Table;

@Table(name = "tab_tell_you")
public class TellYou extends BaseEntity {
    private String yourName;
    private String question;
    private String answer;
    private String content;

    public String getYourName() {
        return yourName;
    }

    public void setYourName(String yourName) {
        this.yourName = yourName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
