package fr.ensicaen.lv223.model.agent.robot;

import fr.ensicaen.lv223.model.agent.Agent;

import java.util.PriorityQueue;
import java.util.Stack;

public class Robot implements Agent {
    private PriorityQueue<Message> priorityQueueMessage;
    @Override
    public void compute() {

    }
    public void addMessage(Message message) {
        this.priorityQueueMessage.add(message);
    }

    private Message getTopMessage(){
        if(priorityQueueMessage.size() != 0){
            return this.priorityQueueMessage.poll();
        }
        return null;
    }
}
