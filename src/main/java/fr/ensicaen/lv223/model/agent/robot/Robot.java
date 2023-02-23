package fr.ensicaen.lv223.model.agent.robot;

import fr.ensicaen.lv223.model.agent.Agent;
import fr.ensicaen.lv223.model.agent.robot.message.Message;

import java.util.PriorityQueue;

public abstract class Robot implements Agent {
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
