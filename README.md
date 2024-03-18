# nfcreader

NFC Reader Plugin for Ionic Capacitor app

## Install

```bash
npm install @adikorici/nfcreader
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`writeNfcTag(...)`](#writenfctag)
* [`startNfcReading(...)`](#startnfcreading)
* [`stopNfcReading(...)`](#stopnfcreading)
* [`setNfcDataCallback(...)`](#setnfcdatacallback)
* [`checkNfcAvailability(...)`](#checknfcavailability)
* [`readNfcTag(...)`](#readnfctag)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### writeNfcTag(...)

```typescript
writeNfcTag(options: { data: string; }) => Promise<{ value: string; }>
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ data: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### startNfcReading(...)

```typescript
startNfcReading(data: any) => Promise<any>
```

| Param      | Type             |
| ---------- | ---------------- |
| **`data`** | <code>any</code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------


### stopNfcReading(...)

```typescript
stopNfcReading(data: any) => Promise<any>
```

| Param      | Type             |
| ---------- | ---------------- |
| **`data`** | <code>any</code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------


### setNfcDataCallback(...)

```typescript
setNfcDataCallback(data: any) => Promise<any>
```

| Param      | Type             |
| ---------- | ---------------- |
| **`data`** | <code>any</code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------


### checkNfcAvailability(...)

```typescript
checkNfcAvailability(options: { available: boolean; }) => Promise<{ available: boolean; }>
```

| Param         | Type                                 |
| ------------- | ------------------------------------ |
| **`options`** | <code>{ available: boolean; }</code> |

**Returns:** <code>Promise&lt;{ available: boolean; }&gt;</code>

--------------------


### readNfcTag(...)

```typescript
readNfcTag(options: { data: string; }) => Promise<{ data: string; }>
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ data: string; }</code> |

**Returns:** <code>Promise&lt;{ data: string; }&gt;</code>

--------------------

</docgen-api>
