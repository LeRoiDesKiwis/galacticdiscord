package fr.leroideskiwis.galacticdiscord.discord.commands;
//Definition of our CommandArgument class
public class CommandArgument {

    private final String title;
    private final ArgumentType type;
    //CommandArgument constructor
    public CommandArgument(String title, ArgumentType type){
        this.title = title;
        this.type = type;
    }
    //CommandArgument constructor, if not specified every argument is required
    public CommandArgument(String title){
        this(title, ArgumentType.REQUIRED);
    }
    //Override of toString method
    @Override
    public String toString() {
        return type.start+title+type.end;
    }
    //Definition of enum  ArgumentType
    public enum ArgumentType{
        OPTIONAL("[", "]"), REQUIRED("<", ">");

        public final String end;
        public final String start;

        ArgumentType(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
