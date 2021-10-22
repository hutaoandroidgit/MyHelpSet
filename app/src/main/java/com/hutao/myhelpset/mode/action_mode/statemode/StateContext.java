package com.hutao.myhelpset.mode.action_mode.statemode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class StateContext {
    private PersonState personState;

    public void fallInLove(){
        System.out.println("恋爱了");
        setPersonState(new LoveState());
    }
    public void outLove(){
        System.out.println("失恋了");
        setPersonState(new DogState());
    }

    public void setPersonState(PersonState personState) {
        this.personState = personState;
    }
    public void movies(){
        personState.movies();
    }
    public void shooping(){
        personState.shooping();
    }
}