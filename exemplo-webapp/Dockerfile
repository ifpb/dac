FROM payara/server-full:latest

USER payara

ENV WAR=exemplo-webapp.war
ENV DEPLOYMENT_DIR=/opt/payara/deployments

COPY target/${WAR} ${DEPLOYMENT_DIR}

RUN echo "AS_ADMIN_PASSWORD=${ADMIN_PASSWORD}" >> ${PASSWORD_FILE}

ENTRYPOINT asadmin --user=${ADMIN_USER} --passwordfile=${PASSWORD_FILE} start-domain ${DOMAIN_NAME} && \
asadmin --user=${ADMIN_USER} --passwordfile=${PASSWORD_FILE} deploy --contextroot '/' ${DEPLOYMENT_DIR}/${WAR} && \
tail -f ${PAYARA_DIR}/glassfish/domains/${DOMAIN_NAME}/logs/server.log