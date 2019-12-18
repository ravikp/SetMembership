#!/usr/bin/env bash

CONNECTION="service:jmx:rmi:///jndi/rmi://localhost:12341/jmxrmi"

jconsole -interval=1 $CONNECTION