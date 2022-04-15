
public interface Observer {
    void update(Object obj);
    void attach();
    void detach();
}
//https://github.com/MirkoBicchierai/SWE/blob/2e7ca2dd45e381ecc405d78e4105133dd0a8d19a/src/agentManager/Program.java#L58