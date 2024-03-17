package ru.mipt.edu.kozub.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import ru.mipt.edu.kozub.annotation.ToString;

@Component
public class TrafficLite {
    @Autowired @Qualifier("starter")
    StateI cur;
    public void next(){
        System.out.println(cur.getName());
        cur=cur.getNextState();
    }
}

interface  StateI{
    public  StateI getNextState();
    public  String getName();
}


class State implements StateI{
    final String name;
    final StateI nextState;

    State(String name, StateI nextState) {
        this.name = name;
        this.nextState = nextState;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", nextState=" + nextState +
                '}';
    }

    @Override
    public StateI getNextState() {
        return nextState;
    }

    @Override
    public String getName() {
        return name;
    }
}

@Configuration
class TrafficLiteConfig{
    @Bean
    @Qualifier("starter")
    State green(@Qualifier("yellowGreen")StateI next){
        return  new State("green", next);
    }

    @Bean
    State yellowGreen(@Qualifier("red")StateI next){
        return  new State("yellow", next);
    }

    @Bean
    State yellowRed(@Qualifier("green")StateI next){
        return  new State("yellow", next);
    }

//    @Bean
//    State red(@Qualifier("yellowRed")StateI next){
//        return  new State("red", next);
//    }
}

@Component
@Qualifier("red")
class Red implements StateI{
    @Autowired @Qualifier("yellowRed")
    State next;

    @Override
    public State getNextState(){
        return next;
    }

    @Override
    public String getName(){
        return "red";
    }
}
