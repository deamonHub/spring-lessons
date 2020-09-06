package ioc.overview.dependency.domain;

import ioc.overview.annotation.Super;

/**
 * 超级用户
 *
 * @author ：ljf
 * @date ：Created in 2020/9/6 16:09
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
