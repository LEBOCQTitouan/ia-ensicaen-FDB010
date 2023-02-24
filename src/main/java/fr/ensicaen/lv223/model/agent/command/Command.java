package fr.ensicaen.lv223.model.agent.command;

public interface Command {
    void apply();
    void unapply();
}
