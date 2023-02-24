package fr.ensicaen.lv223.teams.jamesbond.robot;

import fr.ensicaen.lv223.model.agent.robot.RobotType;
import fr.ensicaen.lv223.model.agent.robot.message.Message;
import fr.ensicaen.lv223.model.agent.robot.specials.APipelineBuilder;

public class PipelineBuilder extends APipelineBuilder {
    public PipelineBuilder(RobotType type) {
        super(type);
    }

    @Override
    public boolean isAvailable( Message m ) {
        return false;
    }

    @Override
    public void compute() {

    }
}
