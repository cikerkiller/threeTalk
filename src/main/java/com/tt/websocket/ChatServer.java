package com.tt.websocket;

import javax.websocket.server.ServerEndpoint;

/**
 * 
 * @author ciker
 * @desc  webSocket服务
 *
 */
@ServerEndpoint(value = "/talkServer", configurator = HttpSessionConfigurator.class)
public class ChatServer {
   /* private static int onlineCount = 0; //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static CopyOnWriteArraySet<ChatServer> webSocketSet = new CopyOnWriteArraySet<ChatServer>();
    private Session session;    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private String username;      //用户名
    private HttpSession httpSession;    //request的session

    private static List<String> list = new ArrayList<>();   //在线列表,记录用户名称
    
    private static Map<String, Session> routetab = new HashMap<>();  //用户名和websocket的session绑定的路由表

    *//**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     *//*
    @OnOpen
    public void onOpen(Session session, EndpointConfig config){
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1;
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        User currentUser=(User) httpSession.getAttribute(TalkConstant.CURRENT_USER);    //获取当前用户
        this.username= currentUser.getUsername();
        list.add(username);           //将用户名加入在线列表
        routetab.put(username, session);   //将用户名和session绑定到路由表
        String message = getMessage("[" + username + "]加入聊天室,当前在线人数为"+getOnlineCount()+"位", "notice",  list);
        broadcast(message);     //广播
    }

    *//**
     * 连接关闭调用的方法
     *//*
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        list.remove(username);        //从在线列表移除这个用户
        routetab.remove(username);
        String message = getMessage("[" + username +"]离开了聊天室,当前在线人数为"+getOnlineCount()+"位", "notice", list);
        broadcast(message);         //广播
    }

    *//**
     * 接收客户端的message,判断是否有接收人而选择进行广播还是指定发送
     * @param _message 客户端发送过来的消息
     *//*
    @OnMessage
    public void onMessage(String _message) {
    	JSONObject chat = JSON.parseObject(_message);
        JSONObject message = JSON.parseObject(chat.get("message").toString());
        if(message.get("to") == null || message.get("to").equals("")){      //如果to为空,则广播;如果不为空,则对指定的用户发送消息
            broadcast(_message);
        }else{
            String [] userlist = message.get("to").toString().split(",");
            singleSend(_message, (Session) routetab.get(message.get("from")));      //发送给自己,这个别忘了
            for(String user : userlist){
                if(!user.equals(message.get("from"))){
                    singleSend(_message, (Session) routetab.get(user));     //分别发送给每个指定用户
                }
            }
        }
    }

    *//**
     * 发生错误时调用
     * @param error
     *//*
    @OnError
    public void onError(Throwable error){
        error.printStackTrace();
    }

    *//**
     * 广播消息
     * @param message
     *//*
    public void broadcast(String message){
        for(ChatServer chat: webSocketSet){
            try {
                chat.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    *//**
     * 对特定用户发送消息
     * @param message
     * @param session
     *//*
    public void singleSend(String message, Session session){
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    *//**
     * 组装返回给前台的消息
     * @param message   交互信息
     * @param type      信息类型
     * @param list      在线列表
     * @return
     *//*
    public String getMessage(String message, String type, List<String> list){
        JSONObject member = new JSONObject();
        member.put("message", message);
        member.put("type", type);
        member.put("list", list);
        return member.toString();
    }

    public  int getOnlineCount() {
        return onlineCount;
    }

    public synchronized void addOnlineCount() {
        ChatServer.onlineCount++;
    }

    public synchronized void subOnlineCount() {
        ChatServer.onlineCount--;
    }*/
}
