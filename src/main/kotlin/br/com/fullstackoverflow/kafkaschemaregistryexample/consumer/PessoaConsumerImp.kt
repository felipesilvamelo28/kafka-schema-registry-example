package br.com.fullstackoverflow.kafkaschemaregistryexample.consumer

import br.com.fullstackoverflow.kafkaschemaregistryexample.entity.Pessoa
import br.com.fullstackoverflow.kafkaschemaregistryexample.entity.PessoaDTO
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.annotation.PartitionOffset
import org.springframework.kafka.annotation.TopicPartition
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class PessoaConsumerImp {

    @KafkaListener(id = "pessoa-consumer",
        topicPartitions = [
            TopicPartition(
                topic = "Pessoa",
                partitions = ["0"],
                partitionOffsets = arrayOf(PartitionOffset(partition = "*", initialOffset = "0"))
            )
        ]
    )
    fun consume(@Payload pessoaDTO: PessoaDTO){
        val pessoa = Pessoa(pessoaDTO.getNome().toString(), pessoaDTO.getSobrenome().toString())
        println("Pessoa recebida")
        println(pessoa.toString())
    }

}