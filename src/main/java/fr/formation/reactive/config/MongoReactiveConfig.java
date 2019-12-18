package fr.formation.reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@EnableReactiveMongoRepositories
public class MongoReactiveConfig extends AbstractReactiveMongoConfiguration {

    @Override
    protected String getDatabaseName() {
	return "test";
    }

    @Bean
    @Override
    public MongoClient reactiveMongoClient() {
	return MongoClients.create();
    }
}