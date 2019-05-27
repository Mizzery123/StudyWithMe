package sg.edu.rp.c346.studywithme;

/**
 * Created by 17000719 on 3/1/2019.
 */

import java.util.Calendar;

public class ToDoItem {

    private String title;
    private Calendar date;
    private String module;
    private String answer;
    private boolean isImportant;

    public ToDoItem(String title, Calendar date, String module, String answer, boolean isImportant) {
        this.title = title;
        this.date = date;
        this.module = module;
        this.answer = answer;
        this.isImportant = isImportant;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getDateString() {
        String str = date.get(Calendar.DAY_OF_MONTH)+"/"+date.get(Calendar.MONTH)+"/"+date.get(Calendar.YEAR);
        return str;
    }

    public String getModule() {
        return module;
    }

    public String getAnswer() {
        return answer;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isImportant(){
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "title='" + title + '\'' +
                ", date=" + getDateString() +
                ", isImportant=" + isImportant +
                '}';
    }
}

