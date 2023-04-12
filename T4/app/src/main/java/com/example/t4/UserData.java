package com.example.t4;

import java.util.ArrayList;
import java.util.Arrays;

public class UserData {
    private UserModel user0, user1, user2, user3, user4;
    private ArrayList<ChatModel> user0Chat, user1Chat, user2Chat, user3Chat, user4Chat;

    private void setUserChat(){
        user0Chat = new ArrayList<ChatModel>(
                Arrays.asList(
                        new ChatModel(1, "Hello, I'm User 0", "10.10"),
                        new ChatModel(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed imperdiet elementum erat, a luctus orci. ", "10.10"),
                        new ChatModel(1, "Vivamus rhoncus efficitur massa, id porta magna volutpat at.", "10.10"),
                        new ChatModel(1, "Donec pretium tellus ac urna rhoncus feugiat. Sed tempor libero eget nisl accumsan, eu fringilla risus feugiat. Suspendisse potenti. Fusce a dui arcu", "10.10"),
                        new ChatModel(1, "Aliquam ac purus elementum", "10.10"),
                        new ChatModel(1, "Quisque justo nibh", "10.10"),
                        new ChatModel(1, "Sed id velit aliquam, malesuada tortor sagittis, maximus felis.", "10.10"),
                        new ChatModel(1, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "10.10"),

                        new ChatModel(2, "Hello, I'm User 0", "10.10"),
                        new ChatModel(2, "Quisque justo nibh", "10.10"),
                        new ChatModel(2, "Suspendisse et sapien velit.", "10.10"),
                        new ChatModel(2, "Hello, I'm User 0", "10.10"),
                        new ChatModel(2, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "10.10"),
                        new ChatModel(2, "Suspendisse et sapien velit.", "10.10"),
                        new ChatModel(2, "Sed id velit aliquam", "10.10"),
                        new ChatModel(2, "velit aliquam", "10.10"),
                        new ChatModel(2, "Nam eleifend", "10.10"),

                        new ChatModel(3, "ello, Suspendisse et sapien velit. Fusce ex lorem", "10.10"),
                        new ChatModel(3, "Hello, I'm User 0", "10.10"),
                        new ChatModel(3, "lOREM ipsum color", "10.10"),
                        new ChatModel(3, "Sed id velit aliquam", "10.10"),
                        new ChatModel(3, "Fusce ex lorem", "10.10"),
                        new ChatModel(3, "Hello, velit aliquam", "10.10"),
                        new ChatModel(3, "Sed tempor libero eget nisl accumsan", "10.10"),
                        new ChatModel(3, "Donec pretium tellus ac urna rhoncus feugiat. Sed tempor libero eget nisl accumsan", "10.10"),
                        new ChatModel(3, "libero eget nisl accumsan", "10.10"),

                        new ChatModel(4, "Hello, I'm User 0", "10.10"),
                        new ChatModel(4, "Hai, Aliquam ac purus elementum", "10.10"),
                        new ChatModel(4, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia", "10.10"),
                        new ChatModel(4, "Hello, I'm User 0", "10.10"),
                        new ChatModel(4, "Sed id velit aliquam", "10.10"),
                        new ChatModel(4, "Hello, I'm User 0", "10.10"),
                        new ChatModel(4, "libero eget nisl accumsan", "10.10"),
                        new ChatModel(4, "Aliquam ac purus elementum", "10.10"),
                        new ChatModel(4, "Aliquam ac purus elementum", "10.10")
                )
        );
        user1Chat = new ArrayList<ChatModel>(
                Arrays.asList(
                        new ChatModel(0, "Hello, I'm Dazai Osamu", "10.10"),
                        new ChatModel(0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed imperdiet elementum erat, a luctus orci. ", "10.10"),
                        new ChatModel(0, "Vivamus rhoncus efficitur massa, id porta magna volutpat at.", "10.10"),
                        new ChatModel(0, "Donec pretium tellus ac urna rhoncus feugiat. Sed tempor libero eget nisl accumsan, eu fringilla risus feugiat. Suspendisse potenti. Fusce a dui arcu", "10.10"),
                        new ChatModel(0, "Fusce ex lorem", "10.10"),
                        new ChatModel(0, "Hello, velit aliquam", "10.10"),
                        new ChatModel(0, "Sed tempor libero eget nisl accumsan", "10.10"),
                        new ChatModel(0, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "10.10")
                )
        );
        user2Chat = new ArrayList<ChatModel>(
                Arrays.asList(
                        new ChatModel(0, "Hello, I'm Oda Eiichiro", "10.10"),
                        new ChatModel(0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed imperdiet elementum erat, a luctus orci. ", "10.10"),
                        new ChatModel(0, "Donec pretium tellus ac urna rhoncus feugiat. Sed tempor libero eget nisl accumsan, eu fringilla risus feugiat. Suspendisse potenti. Fusce a dui arcu", "10.10"),
                        new ChatModel(0, "massa, id porta magna volutpat at.", "10.10"),
                        new ChatModel(0, "Sed id velit aliquam, malesuada tortor sagittis, maximus felis.", "10.10"),
                        new ChatModel(0, "Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "10.10"),
                        new ChatModel(0, "Quisque justo nibh", "10.10"),
                        new ChatModel(0, "Aliquam ac purus elementum", "10.10")
                )
        );
        user3Chat = new ArrayList<ChatModel>(
                Arrays.asList(
                        new ChatModel(0, "Hello, I'm Miyazaki Hayao", "10.10"),
                        new ChatModel(0, "Vivamus rhoncus efficitur massa, id porta magna volutpat at.", "10.10"),
                        new ChatModel(0, "Sed tempor libero eget nisl accumsan, eu fringilla risus feugiat. Suspendisse potenti. Fusce a dui arcu", "10.10"),
                        new ChatModel(0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed imperdiet elementum erat, a luctus orci. ", "10.10"),
                        new ChatModel(0, "Fusce ex lorem", "10.10"),
                        new ChatModel(0, "Quisque justo nibh", "10.10"),
                        new ChatModel(0, "Aliquam ac purus elementum", "10.10"),
                        new ChatModel(0, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "10.10")
                )
        );
        user4Chat = new ArrayList<ChatModel>(
                Arrays.asList(
                        new ChatModel(0, "Hello, I'm Ranpo Edogawa", "10.10"),
                        new ChatModel(0, "Sed tempor libero eget nisl accumsan, eu fringilla risus feugiat. Suspendisse potenti. Fusce a dui arcu", "10.10"),
                        new ChatModel(0, "Vivamus rhoncus efficitur massa, id porta magna volutpat at.", "10.10"),
                        new ChatModel(0, "Sed id velit aliquam, malesuada tortor sagittis, maximus felis.", "10.10"),
                        new ChatModel(0, "Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "10.10"),
                        new ChatModel(0, "Quisque justo nibh", "10.10"),
                        new ChatModel(0, "Pukus pukus laperto tele", "10.10"),
                        new ChatModel(0, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "10.10")
                )
        );


    }

    private void setUser(){
        setUserChat();
        user0 = new UserModel(
                0,
                "MySelf",
                "081234567890",
                "Hello, I'm User 0",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Osamu_Dazai.jpg/640px-Osamu_Dazai.jpg",
                user0Chat
        );
        user1 = new UserModel(
                1,
                "Dazai Osamu",
                "081234567890",
                "Hello, I'm Dazai Osamu. I'm a suicidal writer.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Osamu_Dazai.jpg/640px-Osamu_Dazai.jpg",
                user1Chat
        );
        user2 = new UserModel(
                2,
                "Oda Eiichiro",
                "081234567890",
                "Hello, I'm Oda. I'm the writer of One Piece.",
                "https://static.wikia.nocookie.net/onepiece/images/3/32/Eiichiro_Oda_Infobox.png/revision/latest?cb=20190205110539&path-prefix=id",
                user2Chat
        );
        user3 = new UserModel(
                3,
                "Miyazaki Hayao",
                "081234567890",
                "Hello, I'm Miyazaki Hayao, the studio ghibli's founder.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Hayao_Miyazaki_cropped_1_Hayao_Miyazaki_201211.jpg/800px-Hayao_Miyazaki_cropped_1_Hayao_Miyazaki_201211.jpg",
                user3Chat
        );
        user4 = new UserModel(
                4,
                "Ranpo Edogawa",
                "081234567890",
                "Hello, I'm Ranpo Edogawa.",
                "https://upload.wikimedia.org/wikipedia/commons/3/33/Rampo_Edogawa_02.jpg",
                user4Chat
        );
    }

    public ArrayList<UserModel> getUser(){
        ArrayList<UserModel> user = new ArrayList<UserModel>(Arrays.asList(user0, user1, user2, user3, user4));
        return user;
    }
}
