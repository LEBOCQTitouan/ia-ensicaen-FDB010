package fr.ensicaen.lv223.model.agent.command;

public class CommandFactory {
    private static CommandFactory instance = null;
    //mettre le proxy planete en parametre

    private CommandFactory() {
        //déclacer le proxy planete
    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command createCommand(CommandType type) {
        switch (type) {
            case MOVECOMMAND:
                //return new MoveCommand();
            case COLLECTORECOMMAND:
            case COLLECTFOODCOMMAND:
            case PLANTFOODCOMMAND:
            default:
                return null;
        }
    }
}
