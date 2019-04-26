package com.example.myproject.Stories.model;

import com.example.myproject.R;

import java.util.ArrayList;

public class Stories {
    ArrayList<Story> stories;

    public Stories() {
        stories = new ArrayList<>();
        stories.add(new Story("The Boat", R.drawable.s0));
        stories.add(new Story("Signals from Mars", R.drawable.s1));
        stories.add(new Story("Walking New York", R.drawable.s2));
        stories.add(new Story("Zombie attacks", R.drawable.s3));
        stories.add(new Story("Bacon is tasty", R.drawable.s4));
        stories.add(new Story("Samuel L. Jackson", R.drawable.s5));
        stories.add(new Story("Life of a cat", R.drawable.s6));
        stories.add(new Story("Cheesy Story", R.drawable.s7));
        stories.add(new Story("Pirates", R.drawable.s8));
        stories.add(new Story("The New Burger", R.drawable.s9));
    }
    public Story getStory(int storyIndex){
        return stories.get(storyIndex);
    }
    public int size(){
        return stories.size();
    }
    public void initializePages(int storyNumber){
        switch (storyNumber){
            case 0:
                stories.get(storyNumber).setPage(0, new Page(
                        R.drawable.story1page0,
                        R.string.story1_page0,
                        new Choice(R.string.story1_page0_choice1,1),
                        new Choice(R.string.story1_page0_choice2, 2)));
                stories.get(storyNumber).setPage(1, new Page(
                        R.drawable.story1page1,
                        R.string.story1_page1,
                        new Choice(R.string.story1_page1_choice1,3),
                        new Choice(R.string.story1_page1_choice2, 4)));
                stories.get(storyNumber).setPage(2, new Page(
                        R.drawable.story1page2,
                        R.string.story1_page2,
                        new Choice(R.string.story1_page2_choice1,4),
                        new Choice(R.string.story1_page2_choice2, 6)));
                stories.get(storyNumber).setPage(3, new Page(
                        R.drawable.story1page3,
                        R.string.story1_page3,
                        new Choice(R.string.story1_page3_choice1,5),
                        new Choice(R.string.story1_page3_choice2, 4)));
                stories.get(storyNumber).setPage(4, new Page(
                        R.drawable.story1page4,
                        R.string.story1_page4,
                        new Choice(R.string.story1_page4_choice1,5),
                        new Choice(R.string.story1_page4_choice2, 6)));
                stories.get(storyNumber).setPage(5, new Page(
                        R.drawable.story1page5,
                        R.string.story1_page5));
                stories.get(storyNumber).setPage(6, new Page(
                        R.drawable.story1page6,
                        R.string.story1_page6));
                break;
            case 1:
                stories.get(storyNumber).setPage(0, new Page(
                        R.drawable.story2page0,
                        R.string.story2_page0,
                        new Choice(R.string.story2_page0_choice1,1),
                        new Choice(R.string.story2_page0_choice2, 2)));
                stories.get(storyNumber).setPage(1, new Page(
                        R.drawable.story2page1,
                        R.string.story2_page1,
                        new Choice(R.string.story2_page1_choice1,3),
                        new Choice(R.string.story2_page1_choice2, 4)));
                stories.get(storyNumber).setPage(2, new Page(
                        R.drawable.story2page2,
                        R.string.story2_page2,
                        new Choice(R.string.story2_page2_choice1,4),
                        new Choice(R.string.story2_page2_choice2, 6)));
                stories.get(storyNumber).setPage(3, new Page(
                        R.drawable.story2page3,
                        R.string.story2_page3,
                        new Choice(R.string.story2_page3_choice1,4),
                        new Choice(R.string.story2_page3_choice2, 5)));
                stories.get(storyNumber).setPage(4, new Page(
                        R.drawable.story2page4,
                        R.string.story1_page4,
                        new Choice(R.string.story2_page4_choice1,5),
                        new Choice(R.string.story2_page4_choice2, 6)));
                stories.get(storyNumber).setPage(5, new Page(
                        R.drawable.story2page5,
                        R.string.story2_page5));
                stories.get(storyNumber).setPage(6, new Page(
                        R.drawable.story2page6,
                        R.string.story2_page6));
                break;
            case 2:
                stories.get(storyNumber).setPage(0, new Page(
                        R.drawable.story3page0,
                        R.string.story3_page0,
                        new Choice(R.string.story3_page0_choice1,1),
                        new Choice(R.string.story3_page0_choice2, 2)));
                stories.get(storyNumber).setPage(1, new Page(
                        R.drawable.story3page1,
                        R.string.story3_page1,
                        new Choice(R.string.story3_page1_choice1,3),
                        new Choice(R.string.story3_page1_choice2, 4)));
                stories.get(storyNumber).setPage(2, new Page(
                        R.drawable.story3page2,
                        R.string.story3_page2,
                        new Choice(R.string.story3_page2_choice1,4),
                        new Choice(R.string.story3_page2_choice2, 6)));
                stories.get(storyNumber).setPage(3, new Page(
                        R.drawable.story3page3,
                        R.string.story3_page3,
                        new Choice(R.string.story3_page3_choice1,4),
                        new Choice(R.string.story3_page3_choice2, 5)));
                stories.get(storyNumber).setPage(4, new Page(
                        R.drawable.story3page4,
                        R.string.story3_page4,
                        new Choice(R.string.story3_page4_choice1,5),
                        new Choice(R.string.story3_page4_choice2, 6)));
                stories.get(storyNumber).setPage(5, new Page(
                        R.drawable.story3page5,
                        R.string.story3_page5));
                stories.get(storyNumber).setPage(6, new Page(
                        R.drawable.story3page6,
                        R.string.story3_page6));
                break;
            case 3:
                stories.get(storyNumber).setPage(0, new Page(
                        R.drawable.story4page0,
                        R.string.story4_page0,
                        new Choice(R.string.story4_page0_choice1,1),
                        new Choice(R.string.story4_page0_choice2, 2)));
                stories.get(storyNumber).setPage(1, new Page(
                        R.drawable.story4page1,
                        R.string.story4_page1,
                        new Choice(R.string.story4_page1_choice1,3),
                        new Choice(R.string.story4_page1_choice2, 4)));
                stories.get(storyNumber).setPage(2, new Page(
                        R.drawable.story4page2,
                        R.string.story4_page2,
                        new Choice(R.string.story4_page2_choice1,4),
                        new Choice(R.string.story4_page2_choice2, 6)));
                stories.get(storyNumber).setPage(3, new Page(
                        R.drawable.story4page3,
                        R.string.story4_page3,
                        new Choice(R.string.story4_page3_choice1,4),
                        new Choice(R.string.story4_page3_choice2, 5)));
                stories.get(storyNumber).setPage(4, new Page(
                        R.drawable.story4page4,
                        R.string.story4_page4,
                        new Choice(R.string.story4_page4_choice1,5),
                        new Choice(R.string.story4_page4_choice2, 6)));
                stories.get(storyNumber).setPage(5, new Page(
                        R.drawable.story4page5,
                        R.string.story4_page5));
                stories.get(storyNumber).setPage(6, new Page(
                        R.drawable.story4page6,
                        R.string.story4_page6));
                break;
            case 4:
                stories.get(storyNumber).setPage(0, new Page(
                        R.drawable.story5page0,
                        R.string.story5_page0,
                        new Choice(R.string.story5_page0_choice1,1),
                        new Choice(R.string.story5_page0_choice2, 2)));
                stories.get(storyNumber).setPage(1, new Page(
                        R.drawable.story5page1,
                        R.string.story5_page1,
                        new Choice(R.string.story5_page1_choice1,3),
                        new Choice(R.string.story5_page1_choice2, 4)));
                stories.get(storyNumber).setPage(2, new Page(
                        R.drawable.story5page2,
                        R.string.story5_page2,
                        new Choice(R.string.story5_page2_choice1,4),
                        new Choice(R.string.story5_page2_choice2, 6)));
                stories.get(storyNumber).setPage(3, new Page(
                        R.drawable.story5page3,
                        R.string.story5_page3,
                        new Choice(R.string.story5_page3_choice1,4),
                        new Choice(R.string.story5_page3_choice2, 5)));
                stories.get(storyNumber).setPage(4, new Page(
                        R.drawable.story5page4,
                        R.string.story5_page4,
                        new Choice(R.string.story5_page4_choice1,5),
                        new Choice(R.string.story5_page4_choice2, 6)));
                stories.get(storyNumber).setPage(5, new Page(
                        R.drawable.story5page5,
                        R.string.story5_page5));
                stories.get(storyNumber).setPage(6, new Page(
                        R.drawable.story5page6,
                        R.string.story5_page6));
                break;
            case 5:
                stories.get(storyNumber).setPage(0, new Page(
                        R.drawable.story6page0,
                        R.string.story6_page0,
                        new Choice(R.string.story6_page0_choice1,1),
                        new Choice(R.string.story6_page0_choice2, 2)));
                stories.get(storyNumber).setPage(1, new Page(
                        R.drawable.story6page1,
                        R.string.story6_page1,
                        new Choice(R.string.story6_page1_choice1,3),
                        new Choice(R.string.story6_page1_choice2, 4)));
                stories.get(storyNumber).setPage(2, new Page(
                         R.drawable.story6page2,
                        R.string.story6_page2,
                        new Choice(R.string.story6_page2_choice1,4),
                        new Choice(R.string.story6_page2_choice2, 6)));
                stories.get(storyNumber).setPage(3, new Page(
                        R.drawable.story6page3,
                        R.string.story6_page3,
                        new Choice(R.string.story6_page3_choice1,4),
                        new Choice(R.string.story6_page3_choice2, 5)));
                stories.get(storyNumber).setPage(4, new Page(
                        R.drawable.story6page4,
                        R.string.story6_page4,
                        new Choice(R.string.story6_page4_choice1,5),
                        new Choice(R.string.story6_page4_choice2, 6)));
                stories.get(storyNumber).setPage(5, new Page(
                        R.drawable.story6page5,
                        R.string.story6_page5));
                stories.get(storyNumber).setPage(6, new Page(
                        R.drawable.story6page6,
                        R.string.story6_page6));
                break;
            case 6:
                stories.get(storyNumber).setPage(0, new Page(
                        R.drawable.story7page0,
                        R.string.story7_page0,
                        new Choice(R.string.story7_page0_choice1,1),
                        new Choice(R.string.story7_page0_choice2, 2)));
                stories.get(storyNumber).setPage(1, new Page(
                        R.drawable.story7page1,
                        R.string.story7_page1,
                        new Choice(R.string.story7_page1_choice1,3),
                        new Choice(R.string.story7_page1_choice2, 4)));
                stories.get(storyNumber).setPage(2, new Page(
                        R.drawable.story7page2,
                        R.string.story7_page2,
                        new Choice(R.string.story7_page2_choice1,4),
                        new Choice(R.string.story7_page2_choice2, 6)));
                stories.get(storyNumber).setPage(3, new Page(
                        R.drawable.story7page3,
                        R.string.story7_page3,
                        new Choice(R.string.story7_page3_choice1,4),
                        new Choice(R.string.story7_page3_choice2, 5)));
                stories.get(storyNumber).setPage(4, new Page(
                        R.drawable.story7page4,
                        R.string.story7_page4,
                        new Choice(R.string.story7_page4_choice1,5),
                        new Choice(R.string.story7_page4_choice2, 6)));
                stories.get(storyNumber).setPage(5, new Page(
                        R.drawable.story7page5,
                        R.string.story7_page5));
                stories.get(storyNumber).setPage(6, new Page(
                        R.drawable.story7page6,
                        R.string.story7_page6));
                break;
            case 7:
                stories.get(storyNumber).setPage(0, new Page(
                        R.drawable.story8page0,
                        R.string.story8_page0,
                        new Choice(R.string.story8_page0_choice1,1),
                        new Choice(R.string.story8_page0_choice2, 2)));
                stories.get(storyNumber).setPage(1, new Page(
                        R.drawable.story8page1,
                        R.string.story8_page1,
                        new Choice(R.string.story8_page1_choice1,3),
                        new Choice(R.string.story8_page1_choice2, 4)));
                stories.get(storyNumber).setPage(2, new Page(
                        R.drawable.story8page2,
                        R.string.story8_page2,
                        new Choice(R.string.story8_page2_choice1,4),
                        new Choice(R.string.story8_page2_choice2, 6)));
                stories.get(storyNumber).setPage(3, new Page(
                        R.drawable.story8page3,
                        R.string.story8_page3,
                        new Choice(R.string.story8_page3_choice1,4),
                        new Choice(R.string.story8_page3_choice2, 5)));
                stories.get(storyNumber).setPage(4, new Page(
                        R.drawable.story8page4,
                        R.string.story8_page4,
                        new Choice(R.string.story8_page4_choice1,5),
                        new Choice(R.string.story8_page4_choice2, 6)));
                stories.get(storyNumber).setPage(5, new Page(
                        R.drawable.story8page5,
                        R.string.story8_page5));
                stories.get(storyNumber).setPage(6, new Page(
                        R.drawable.story8page6,
                        R.string.story8_page6));
                break;
            case 8:
                stories.get(storyNumber).setPage(0, new Page(
                        R.drawable.story9page0,
                        R.string.story9_page0,
                        new Choice(R.string.story9_page0_choice1,1),
                        new Choice(R.string.story9_page0_choice2, 2)));
                stories.get(storyNumber).setPage(1, new Page(
                        R.drawable.story9page1,
                        R.string.story9_page1,
                        new Choice(R.string.story9_page1_choice1,3),
                        new Choice(R.string.story9_page1_choice2, 4)));
                stories.get(storyNumber).setPage(2, new Page(
                        R.drawable.story9page2,
                        R.string.story9_page2,
                        new Choice(R.string.story9_page2_choice1,4),
                        new Choice(R.string.story9_page2_choice2, 6)));
                stories.get(storyNumber).setPage(3, new Page(
                        R.drawable.story9page3,
                        R.string.story9_page3,
                        new Choice(R.string.story9_page3_choice1,4),
                        new Choice(R.string.story9_page3_choice2, 5)));
                stories.get(storyNumber).setPage(4, new Page(
                        R.drawable.story9page4,
                        R.string.story9_page4,
                        new Choice(R.string.story9_page4_choice1,5),
                        new Choice(R.string.story9_page4_choice2, 6)));
                stories.get(storyNumber).setPage(5, new Page(
                        R.drawable.story9page5,
                        R.string.story9_page5));
                stories.get(storyNumber).setPage(6, new Page(
                        R.drawable.story9page6,
                        R.string.story9_page6));
                break;
            case 9:
                stories.get(storyNumber).setPage(0, new Page(
                        R.drawable.story10page0,
                        R.string.story10_page0,
                        new Choice(R.string.story10_page0_choice1,1),
                        new Choice(R.string.story10_page0_choice2, 2)));
                stories.get(storyNumber).setPage(1, new Page(
                        R.drawable.story10page1,
                        R.string.story10_page1,
                        new Choice(R.string.story10_page1_choice1,3),
                        new Choice(R.string.story10_page1_choice2, 4)));
                stories.get(storyNumber).setPage(2, new Page(
                        R.drawable.story10page2,
                        R.string.story10_page2,
                        new Choice(R.string.story10_page2_choice1,4),
                        new Choice(R.string.story10_page2_choice2, 6)));
                stories.get(storyNumber).setPage(3, new Page(
                        R.drawable.story10page3,
                        R.string.story10_page3,
                        new Choice(R.string.story10_page3_choice1,4),
                        new Choice(R.string.story2_page3_choice2, 5)));
                stories.get(storyNumber).setPage(4, new Page(
                        R.drawable.story10page4,
                        R.string.story1_page4,
                        new Choice(R.string.story2_page4_choice1,5),
                        new Choice(R.string.story2_page4_choice2, 6)));
                stories.get(storyNumber).setPage(5, new Page(
                        R.drawable.story10page5,
                        R.string.story2_page5));
                stories.get(storyNumber).setPage(6, new Page(
                        R.drawable.story10page6,
                        R.string.story2_page6));
                break;
        }
    }
}
