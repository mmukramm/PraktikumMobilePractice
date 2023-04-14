package com.example.t4;

import java.util.ArrayList;
import java.util.Arrays;

public class UserData {
    private static UserModel user0, user1, user2, user3, user4, user5, user6;
    private static ArrayList<ChatModel> user0Chat, user1Chat, user2Chat, user3Chat, user4Chat, user5Chat, user6Chat;

    private static void setUserChat(){
        user0Chat = new ArrayList<ChatModel>(
                Arrays.asList(
                        new ChatModel(1, "Hello, I'm User 0", "10:10"),
                        new ChatModel(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed imperdiet elementum erat, a luctus orci. ", "10:10"),
                        new ChatModel(1, "Vivamus rhoncus efficitur massa, id porta magna volutpat at.", "10:10"),
                        new ChatModel(1, "Donec pretium tellus ac urna rhoncus feugiat. Sed tempor libero eget nisl accumsan, eu fringilla risus feugiat. Suspendisse potenti. Fusce a dui arcu", "10:15"),
                        new ChatModel(1, "Aliquam ac purus elementum", "10:17"),
                        new ChatModel(1, "Quisque justo nibh", "10:19"),
                        new ChatModel(1, "Sed id velit aliquam, malesuada tortor sagittis, maximus felis.", "10:25"),
                        new ChatModel(1, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "10:30"),

                        new ChatModel(2, "Hello, I'm User 0", "11:15"),
                        new ChatModel(2, "Quisque justo nibh", "11:15"),
                        new ChatModel(2, "Suspendisse et sapien velit.", "11:18"),
                        new ChatModel(2, "Hello, I'm User 0", "11:18"),
                        new ChatModel(2, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "11:25"),
                        new ChatModel(2, "Suspendisse et sapien velit.", "11:26"),
                        new ChatModel(2, "Sed id velit aliquam", "11:30"),
                        new ChatModel(2, "velit aliquam", "11:35"),
                        new ChatModel(2, "Nam eleifend", "11:35"),

                        new ChatModel(3, "ello, Suspendisse et sapien velit. Fusce ex lorem", "11:16"),
                        new ChatModel(3, "Hello, I'm User 0", "11:20"),
                        new ChatModel(3, "lOREM ipsum color", "11:20"),
                        new ChatModel(3, "Sed id velit aliquam", "11:25"),
                        new ChatModel(3, "Fusce ex lorem", "11:25"),
                        new ChatModel(3, "Hello, velit aliquam", "11:25"),
                        new ChatModel(3, "Sed tempor libero eget nisl accumsan", "11:30"),
                        new ChatModel(3, "Donec pretium tellus ac urna rhoncus feugiat. Sed tempor libero eget nisl accumsan", "11:31"),
                        new ChatModel(3, "libero eget nisl accumsan", "11:35"),

                        new ChatModel(4, "Hello, I'm User 0", "12:00"),
                        new ChatModel(4, "Hai, Aliquam ac purus elementum", "12:00"),
                        new ChatModel(4, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia", "12:05"),
                        new ChatModel(4, "Hello, I'm User 0", "12:10"),
                        new ChatModel(4, "Sed id velit aliquam", "12:10"),
                        new ChatModel(4, "Hello, I'm User 0", "12:20"),
                        new ChatModel(4, "libero eget nisl accumsan", "12:20"),
                        new ChatModel(4, "Aliquam ac purus elementum", "12:20"),
                        new ChatModel(4, "Aliquam ac purus elementum", "12:25"),

                        new ChatModel(5, "Hello, I'm User 0", "12:00"),
                        new ChatModel(5, "Hai, Aliquam ac purus elementum", "12:00"),
                        new ChatModel(5, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia", "12:05"),
                        new ChatModel(5, "Elepoente das uniqlo omega", "12:10"),
                        new ChatModel(5, "Sed id velit aliquam", "12:10"),
                        new ChatModel(5, "Hello, Suspendisse facilis", "12:35"),

                        new ChatModel(6, "Hello, I'm User 0", "12:00"),
                        new ChatModel(6, "Hai, Aliquam ac purus elementum", "12:00"),
                        new ChatModel(6, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia", "12:05"),
                        new ChatModel(6, "Elepoente das uniqlo omega", "12:10"),
                        new ChatModel(6, "Sed id velit aliquam", "12:10"),
                        new ChatModel(6, "Hello, Suspendisse facilisticusse lerpente", "12:50")

                )
        );
        user1Chat = new ArrayList<ChatModel>(
                Arrays.asList(
                        new ChatModel(0, "Hello, I'm Dazai Osamu", "10:12"),
                        new ChatModel(0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed imperdiet elementum erat, a luctus orci. ", "10:13"),
                        new ChatModel(0, "Vivamus rhoncus efficitur massa, id porta magna volutpat at.", "10:18"),
                        new ChatModel(0, "Donec pretium tellus ac urna rhoncus feugiat. Sed tempor libero eget nisl accumsan, eu fringilla risus feugiat. Suspendisse potenti. Fusce a dui arcu", "10:18"),
                        new ChatModel(0, "Fusce ex lorem", "10:18"),
                        new ChatModel(0, "Hello, velit aliquam", "10:20"),
                        new ChatModel(0, "Sed tempor libero eget nisl accumsan", "10:26"),
                        new ChatModel(0, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "10:32")
                )
        );
        user2Chat = new ArrayList<ChatModel>(
                Arrays.asList(
                        new ChatModel(0, "Hello, I'm Oda Eiichiro", "11:16"),
                        new ChatModel(0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed imperdiet elementum erat, a luctus orci. ", "11:20"),
                        new ChatModel(0, "Donec pretium tellus ac urna rhoncus feugiat. Sed tempor libero eget nisl accumsan, eu fringilla risus feugiat. Suspendisse potenti. Fusce a dui arcu", "11:25"),
                        new ChatModel(0, "massa, id porta magna volutpat at.", "11:25"),
                        new ChatModel(0, "Sed id velit aliquam, malesuada tortor sagittis, maximus felis.", "11:25"),
                        new ChatModel(0, "Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "11:30"),
                        new ChatModel(0, "Quisque justo nibh", "11:30"),
                        new ChatModel(0, "Aliquam ac purus elementum", "11:36")
                )
        );
        user3Chat = new ArrayList<ChatModel>(
                Arrays.asList(
                        new ChatModel(0, "Hello, I'm Miyazaki Hayao", "11:16"),
                        new ChatModel(0, "Vivamus rhoncus efficitur massa, id porta magna volutpat at.", "11:20"),
                        new ChatModel(0, "Sed tempor libero eget nisl accumsan, eu fringilla risus feugiat. Suspendisse potenti. Fusce a dui arcu", "11:20"),
                        new ChatModel(0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed imperdiet elementum erat, a luctus orci. ", "11:25"),
                        new ChatModel(0, "Fusce ex lorem", "11:30"),
                        new ChatModel(0, "Quisque justo nibh", "11:35"),
                        new ChatModel(0, "Aliquam ac purus elementum", "11:37"),
                        new ChatModel(0, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "11:45")
                )
        );
        user4Chat = new ArrayList<ChatModel>(
                Arrays.asList(
                        new ChatModel(0, "Hello, I'm Ranpo Edogawa", "12:03"),
                        new ChatModel(0, "Sed tempor libero eget nisl accumsan, eu fringilla risus feugiat. Suspendisse potenti. Fusce a dui arcu", "12:07"),
                        new ChatModel(0, "Vivamus rhoncus efficitur massa, id porta magna volutpat at.", "12:07"),
                        new ChatModel(0, "Sed id velit aliquam, malesuada tortor sagittis, maximus felis.", "12:07"),
                        new ChatModel(0, "Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "12:12"),
                        new ChatModel(0, "Quisque justo nibh", "12:13"),
                        new ChatModel(0, "Pukus pukus laperto tele", "12:18"),
                        new ChatModel(0, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "12:25")
                )
        );
        user5Chat = new ArrayList<ChatModel>(
                Arrays.asList(
                        new ChatModel(0, "Hello, I'm Mori Ougai", "12:03"),
                        new ChatModel(0, "Sed tempor libero eget nisl accumsan, eu fringilla risus feugiat. Suspendisse potenti. Fusce a dui arcu", "12:07"),
                        new ChatModel(0, "Vivamus rhoncus efficitur massa, id porta magna volutpat at.", "12:07"),
                        new ChatModel(0, "Sed id velit aliquam, malesuada tortor sagittis, maximus felis.", "12:07"),
                        new ChatModel(0, "Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "12:12"),
                        new ChatModel(0, "Quisque justo nibh", "12:13"),
                        new ChatModel(0, "Pukus pukus laperto tele", "12:18"),
                        new ChatModel(0, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "12:30")
                )
        );
        user6Chat = new ArrayList<ChatModel>(
                Arrays.asList(
                        new ChatModel(0, "Hello, I'm Atsushi Nakajima", "12:03"),
                        new ChatModel(0, "Sed tempor libero eget nisl accumsan, eu fringilla risus feugiat. Suspendisse potenti. Fusce a dui arcu", "12:07"),
                        new ChatModel(0, "Vivamus rhoncus efficitur massa, id porta magna volutpat at.", "12:07"),
                        new ChatModel(0, "Sed id velit aliquam, malesuada tortor sagittis, maximus felis.", "12:07"),
                        new ChatModel(0, "Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "12:12"),
                        new ChatModel(0, "Quisque justo nibh", "12:13"),
                        new ChatModel(0, "Pukus pukus laperto tele", "12:18"),
                        new ChatModel(0, "Nam eleifend sed justo ut facilisis. Suspendisse et sapien velit. Fusce ex lorem, tempus vel lacinia ac, tempus eu enim.", "12:55")
                )
        );


    }

    private static void setUser(){
        setUserChat();
        user0 = new UserModel(
                0,
                "MySelf",
                "081345634590",
                "Hello, I'm User 0",
                "https://i.pinimg.com/236x/35/dd/6a/35dd6a82000dcce2d27ff6d74d105606.jpg",
                user0Chat
        );
        user1 = new UserModel(
                1,
                "Dazai Osamu",
                "081323456490",
                "Hello, I'm Dazai Osamu. I'm a suicidal writer.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Osamu_Dazai.jpg/640px-Osamu_Dazai.jpg",
                user1Chat
        );
        user2 = new UserModel(
                2,
                "Oda Eiichiro",
                "081234323250",
                "Hello, I'm Oda. I'm the writer of One Piece.",
                "https://static.wikia.nocookie.net/onepiece/images/3/32/Eiichiro_Oda_Infobox.png/revision/latest?cb=20190205110539&path-prefix=id",
                user2Chat
        );
        user3 = new UserModel(
                3,
                "Miyazaki Hayao",
                "08123235672234",
                "Hello, I'm Miyazaki Hayao, the studio ghibli's founder.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Hayao_Miyazaki_cropped_1_Hayao_Miyazaki_201211.jpg/800px-Hayao_Miyazaki_cropped_1_Hayao_Miyazaki_201211.jpg",
                user3Chat
        );
        user4 = new UserModel(
                4,
                "Ranpo Edogawa",
                "081234325344",
                "Hello, I'm Ranpo Edogawa.",
                "https://upload.wikimedia.org/wikipedia/commons/3/33/Rampo_Edogawa_02.jpg",
                user4Chat
        );
        user5 = new UserModel(
                5,
                "Mori Ogai",
                "08123498129",
                "Hello, I'm Mori Ogai. I'm a writer, poet, and military doctor.",
                "https://upload.wikimedia.org/wikipedia/commons/7/71/Mori_Ogai_in_the_atelier_of_Sculptor_Takeishi_Kozaburo_in_1916.jpg",
                user5Chat
        );
        user6 = new UserModel(
                6,
                "Atsushi Nakajima",
                "08100987162",
                "Hello, I'm Atsushi, writer and inspirator behind Bungou Stray Dogs main character.",
                "https://upload.wikimedia.org/wikipedia/commons/4/45/AtsushiNakajima.jpg",
                user6Chat
        );
    }

    public static ArrayList<UserModel> getUser(){
        setUser();
        ArrayList<UserModel> user = new ArrayList<UserModel>(Arrays.asList(user0, user1, user2, user3, user4, user5, user6));
        return user;
    }
}
