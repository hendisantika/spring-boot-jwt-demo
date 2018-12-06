# spring-boot-jwt-demo

This repository is intended as an example to do authentication using JWT

Things to do :

1. You have to install Consul Server first from [here](https://www.consul.io/downloads.html)
2. Run the Consul agent from [here](https://www.consul.io/intro/getting-started/agent.html)
   `consul agent -dev`
3. [Consul Command](https://www.consul.io/docs/commands/index.html)


Before authorized every request, the request has to check whether the token still valid by checking the registered ID in Consul KV Database.

If the token expired, then the registered ID has to be removed from KV database
References

https://auth0.com/blog/securing-spring-boot-with-jwts/