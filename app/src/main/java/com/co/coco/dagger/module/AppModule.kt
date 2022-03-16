package com.co.coco.dagger.module

import com.co.coco.model.Computer
import com.co.coco.model.Motherboard
import com.co.coco.model.Processor
import com.co.coco.model.RAM
import dagger.Module
import dagger.Provides

/**
 * Модули, который мы долджны передать в компонент
 */
@Module
object AppModule {

    /**
     * Предоставляет объекты
     */
    @Provides
    fun provideComputer(
        processor: Processor,
        motherboard: Motherboard,
        ram: RAM
    ): Computer {
        return Computer(
            processor = processor,
            motherboard = motherboard,
            ram = ram
        )
    }

    @Provides
    fun provideProcessor(): Processor {
        return Processor()
    }

    @Provides
    fun provideMotherboard(): Motherboard {
        return Motherboard()
    }

    @Provides
    fun provideRam(): RAM {
        return RAM()
    }
}