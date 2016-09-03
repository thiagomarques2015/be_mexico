package br.com.bemexico;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiago on 02/09/2016.
 */
public class Detail {
    private int image;
    private String title, extra;
    private String titleList1, titleList2;
    private List<String> list1;
    private List<String> list2;

    public Detail() {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleList1() {
        return titleList1;
    }

    public void setTitleList1(String titleList1) {
        this.titleList1 = titleList1;
    }

    public String getTitleList2() {
        return titleList2;
    }

    public void setTitleList2(String titleList2) {
        this.titleList2 = titleList2;
    }

    public void addList1(String text){
        list1.add(text);
    }

    public void addList2(String text){
        list2.add(text);
    }

    public List<String> getList1() {
        return list1;
    }

    public List<String> getList2() {
        return list2;
    }

    public boolean hasList1() {
        return list1.size() > 0;
    }

    public boolean hasList2() {
        return list2.size() > 0;
    }
}
