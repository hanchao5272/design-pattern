package pers.hanchao.designpattern.state.state2.state;

/**
 * <p>射击状态</P>
 *
 * @author hanchao
 */
public interface State {

    /**
     * 射击
     */
    public void shoot();

    /**
     * 填充子弹
     */
    public void fill();
}
