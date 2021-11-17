package com.sf.bungker.app.security;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import com.sf.bungker.app.entities.User;

public class MyUserDetails implements UserDetails
{
    private final User user;

    private final Collection<? extends GrantedAuthority> roles;

    MyUserDetails(User user, Collection<? extends GrantedAuthority> roles)
    {
        this.user = user;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return roles;
    }

    @Override
    public String getPassword()
    {
        return user.getPassword();
    }

    @Override
    public String getUsername()
    {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        //return user.getAccountNonExpired();
    	return false;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        //return user.getAccountNonLocked();
    	return false;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired()
    {
        //return user.getCredentialsNonExpired();
    	return false;
    }

    @Override
    public boolean isEnabled()
    {
        //return user.getActive();
    	return true;
    }

}